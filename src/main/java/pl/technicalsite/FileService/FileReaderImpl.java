package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static pl.technicalsite.TemplateModel.TemplateKeys.*;
import static pl.technicalsite.TemplateModel.TemplateRegex.*;

@Service
public class FileReaderImpl implements FileReader {

    private static final Logger logger = LogManager.getLogger(FileReaderImpl.class);

    @Override
    public Map<String, String> readFromXsl(String xsl) {
        List<String> file = splitToLine(xsl);
        List<String> customLine = splitHeadersToCustomLines(file.get(0));
        try {
            Map<String, String> structureFile = addKeys(resolveStandardKey(customLine, structureLine), structureList);
            Map<String, String> standardKeys = addKeys(resolveStandardKey(file, classicKey), classicKeyList);
            Map<String, String> numericKeys = addKeys(readBooleanValues(file, keyInNumericLine), numericKeyList);
            Map<String, String> valuesKeys = addKeysInNumeric(readBooleanValues(file, valueInNumericLine), numericValueList);
            Map<String, String> currencyKey = addKeys(resolveCurrency(file, currencyValue), currencyList);
            Map<String, String> customLinesKeys = addKeys(resolveCustomLines(customLine, cutLine), customCutLineList);
            return mergeMaps(customLinesKeys, standardKeys, numericKeys, valuesKeys, currencyKey, structureFile);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Too much line to read, regex found more than it should have: " + e);
            return Collections.emptyMap();
        } catch (Exception e) {
            logger.error("Error during read file: " + e);
            return Collections.emptyMap();
        }
    }

    @SafeVarargs
    private Map<String, String> mergeMaps(Map<String, String>... maps) {
        Map<String, String> mergedMap = new HashMap<>();
        for (Map<String, String> map : maps) {
            mergedMap.putAll(map);
        }
        return mergedMap;

    }

    private List<String> resolveValues(String xsl, String pattern) {
        List<String> elements = new ArrayList<>();
        Matcher matcher = Pattern.compile(pattern).matcher(xsl);

        while (matcher.find()) {
            String element = matcher.group(1);
            if (element != null) {
                elements.add(element.equalsIgnoreCase("UNDEFINED") ? "" : element);
            }
        }
        return elements;
    }

    private List<String> resolveBooleanValues(String xsl, String pattern) {
        List<String> elements = new ArrayList<>();
        Matcher matcher = Pattern.compile(pattern).matcher(xsl);

        while (matcher.find()) {
            String element = matcher.group(1);
            if (element != null) {
                elements.add(element.equalsIgnoreCase("UNDEFINED") ? "" : element);
            }
        }
        return elements;
    }

    private List<String> resolveCustomLines(List<String> lines, String pattern) {
        try {
            return lines.stream()
                    .map(line -> resolveValues(line, pattern))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error during resolving custom lines", e);
            return Collections.emptyList();
        }
    }

    private List<String> splitToLine(String xsl) {
        return Arrays.asList(xsl.split("<!--"));
    }

    private Map<String, String> addKeys(List<String> key, List<String> values) {
        Map<String, String> keysMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            keysMap.put(values.get(i), key.get(i));
        }
        return keysMap;
    }

    private Map<String, String> addKeysInNumeric(List<String> keys, List<String> values) {
        Map<String, String> keysMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            keysMap.put(values.get(i), keys.get(i).equals("UNDEFINED") ? " " : keys.get(i));
        }
        return keysMap;
    }

    private List<String> resolveStandardKey(List<String> fileLineByLine, String pattern) {
        try {
            return fileLineByLine.stream()
                    .map(line -> resolveValues(line, pattern))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        } catch (ArrayIndexOutOfBoundsException a) {
            logger.error("I have a problem when reading primary keys");
            return Collections.emptyList();
        } catch (Exception e) {
            return buildFailedException(e);
        }
    }

    private List<String> readBooleanValues(List<String> fileLineByLine, String pattern) {
        try {
            return fileLineByLine.stream()
                    .map(line -> resolveBooleanValues(line, pattern))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        } catch (ArrayIndexOutOfBoundsException a) {
            logger.error("I have a problem when reading boolean values");
            return Collections.emptyList();
        } catch (Exception e) {
            return buildFailedException(e);
        }
    }

    private List<String> resolveCurrency(List<String> fileLineByLine, String pattern) {
        try {
            return fileLineByLine.stream()
                    .map(line -> resolveBooleanValues(line, pattern))
                    .flatMap(List::stream)
                    .limit(1)
                    .collect(Collectors.toList());
        } catch (ArrayIndexOutOfBoundsException a) {
            logger.error("I have a problem when reading currency");
            return Collections.emptyList();
        } catch (Exception e) {
            return buildFailedException(e);
        }
    }

    private List<String> splitHeadersToCustomLines(String partOfFile) {
        return Arrays.stream(partOfFile.split(">"))
                .map(item -> item + '>')
                .collect(Collectors.toList());
    }

    private List<String> buildFailedException(Exception e) {
        logger.error("Error during read the file " + e);
        return Collections.emptyList();
    }

}

