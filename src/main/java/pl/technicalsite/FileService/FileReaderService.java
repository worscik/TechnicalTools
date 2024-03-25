package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.technicalsite.FileModel.Template.FileFields.*;
import static pl.technicalsite.FileModel.Template.TemplateRegex.*;

@Service
public class FileReaderService implements IFileReader {
    private static final int ONE_ELEMENT = 1;

    private static final Logger logger = LogManager.getLogger(FileReaderService.class);

    @Override
    public Map<String, String> readFromXsl(String xsl) {
        List<String> file = splitToLine(xsl);
        List<String> customLine = splitHeadersToCustomLines(file.get(0));
        try {
            Map<String, String> structureFile = addKeys(resolveStandardKey(file, structure), structureList);
            Map<String, String> standardKeys = addKeys(resolveStandardKey(file, classicKey), classicKeyList);
            Map<String, String> numericKeys = addKeys(readBoolenValues(file, keyInNumericLine), numericKeyList);
            Map<String, String> valuesKeys = addKeysInNumeric(readBoolenValues(file, valueInNumericLine), numericValueList);
            Map<String, String> currencyKey = addKeys(resolveCurrency(file, currencyValue), currencyList);
            Map<String, String> customLinesKeys = addKeys(resolveCustomLines(customLine, customLines), customCutLineList);
            return mergeMaps(customLinesKeys, standardKeys, numericKeys, valuesKeys, currencyKey, structureFile);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Too much line to read, regex found more than it should have: " + e);
            return null;
        } catch (Exception e) {
            logger.error("Error during read file: " + e);
            return null;
        }
    }

    private Map<String, String> mergeMaps(Map<String, String>... maps) {
        Map<String, String> mergedMap = new HashMap<>();
        for (Map<String, String> map : maps) {
            mergedMap.putAll(map);
        }
        return mergedMap;

    }

    private List<String> resolveValues(String xsl, String pattern) {
        List<String> elements = new ArrayList<>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(xsl);

        while (m.find()) {
            if (m.group(1) != null) {
                String element = m.group(1);
                if (element.equalsIgnoreCase("UNDEFINED")) {
                    element = "";
                }
                elements.add(element);
            }
        }
        return elements;
    }

    private List<String> resolveBooleanValues(String xsl, String pattern) {
        List<String> elements = new ArrayList<>();
        if (xsl.contains("<xsl:when test=\\\"UNDEFINED\\\"")) {
            elements.add("");
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(xsl);
        while (m.find()) {
            if (m.group(1) != null) {
                String element = m.group(1);
                if (element.equalsIgnoreCase("UNDEFINED")) {
                    element = "";
                }
                elements.add(element);
            }
        }
        return elements;
    }

    private List<String> resolveCustomLines(List<String> xsl, String pattern) {
        try {
            List<String> values = xsl.stream()
                    .map(line -> resolveValues(line, pattern))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
            if (values.size() == ONE_ELEMENT) {
                values.add(" ");
            }
            return values;
        } catch (ArrayIndexOutOfBoundsException a) {
            logger.error("I have a problem when reading custom lines");
            return Collections.emptyList();
        } catch (Exception e) {
            logger.error("Error during read structure " + e);
            return Collections.emptyList();
        }
    }


    private List<String> splitToLine(String xsl) {
        return Arrays.asList(xsl.split("<!--"));
    }

    private Map<String, String> addKeys(List<String> key, List<String> values) {
        return IntStream.range(0, key.size())
                .collect(HashMap::new, (map, i) -> map.put(values.get(i), key.get(i)), HashMap::putAll);
    }

    private Map<String, String> addKeysInNumeric(List<String> key, List<String> values) {
        Map<String, String> emptyMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            if (key.get(i).equals("UNDEFINED")) {
                emptyMap.put(values.get(i), " ");
            } else {
                emptyMap.put(values.get(i), key.get(i));
            }

        }
        return emptyMap;
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
            logger.error("Error during read structure " + e);
            return Collections.emptyList();
        }
    }

    private List<String> readBoolenValues(List<String> fileLineByLine, String pattern) {
        return fileLineByLine.stream()
                .map(line -> resolveBooleanValues(line, pattern))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<String> resolveCurrency(List<String> fileLineByLine, String pattern) {
        return fileLineByLine.stream()
                .map(line -> resolveBooleanValues(line, pattern))
                .flatMap(List::stream)
                .limit(1)
                .collect(Collectors.toList());
    }

    private List<String> splitHeadersToCustomLines(String partOfFile) {
        return Arrays.asList(partOfFile.split(">")).stream().map(item -> item+='>').toList();
    }

}

