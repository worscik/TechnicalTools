package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static pl.technicalsite.FileModel.Template.FileFields.*;
import static pl.technicalsite.FileModel.Template.TemplateRegex.*;

@Service
public class FileReaderService implements IFileReader {

    private static final Logger logger = LogManager.getLogger(FileReaderService.class);

    @Override
    public Map<String, String> readFromXsl(String xsl) {
        try {
            List<String> file = splitToLine(xsl);
            Map<String, String> structureFile = addKeys(readValues(file, structure), structureList);
            Map<String, String> standardKeys = addKeys(readValues(file, classicKey), classicKeyList);
            Map<String, String> numericKeys = addKeys(readBoolenValues(file, keyInNumericLine), numericKeyList);
            Map<String, String> valuesKeys = addKeysInNumeric(readBoolenValues(file, valueInNumericLine), numericValueList);
            Map<String, String> currencyKey = addKeys(readValues(file, currencyValue), currencyList);
            return mergeMaps(standardKeys, numericKeys, valuesKeys, currencyKey, structureFile);
        } catch (Exception e) {
            logger.error("Error during read file: " + e);
            return Collections.emptyMap();
        }

    }

    @Override
    public Map<String, String> mergeMaps(Map<String, String> structureFile,
                                         Map<String, String> keys,
                                         Map<String, String> numeric,
                                         Map<String, String> values,
                                         Map<String, String> currency) {
        Map<String, String> list = new HashMap<>();
        list.putAll(structureFile);
        list.putAll(keys);
        list.putAll(numeric);
        list.putAll(values);
        list.putAll(currency);
        return list;

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


    private List<String> splitToLine(String xsl) {
        List<String> file = new ArrayList<>();
        String[] lines = xsl.split("<!--");
        file.addAll(Arrays.asList(lines));
        return file;
    }

    private Map<String, String> addKeys(List<String> key, List<String> values) {
        Map<String, String> emptyMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            emptyMap.put(values.get(i), key.get(i));
        }
        return emptyMap;
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

    private List<String> readValues(List<String> fileLineByLine, String pattern) {
        return fileLineByLine.stream()
                .map(line -> resolveValues(line, pattern))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<String> readBoolenValues(List<String> fileLineByLine, String pattern) {
        return fileLineByLine.stream()
                .map(line -> resolveBooleanValues(line, pattern))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}

