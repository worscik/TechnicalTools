package pl.technicalsite.FileService;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static pl.technicalsite.FileModel.MappingsType.listOfAvailableStructure;

@Service
public class XslReaderImpl implements XslReader {

    private List<String> structureList = List.of("structure");
    private List<String> classicKeyList = List.of("id", "name",
            "brand", "categories", "categoryMain", "description", "detail1",
            "detail2", "detail3", "detail4", "detail5", "manufacturer", "price", "pricePromo", "quantityKey",
            "urlProduct", "urlImg", "urlCategory", "urlCategoryMark", "popularity", "season",
            "color", "addidtionalImage");
    private List<String> numericKeyList = List.of("newProductKey", "availableKey", "bestsellerKey", "genderKey");
    private List<String> numericValueList = List.of("newProductValue", "availableValue", "bestsellerValue","genderValue");
    private List<String> currencyList = List.of("currency");

    private final String structure = "(?:template.match\\=\\\\\\\"([A-z\\/]+)\\\\)";
    private final String classicKey = "(?:when test=\\\\\\\"string-length\\((.*)\\)\\\\\\\">\\\\)";
    private final String keyInNumericLine = "(?:when test\\=\\\\\\\"(.*) (=|>))";
    private final String valueInNumericLine = "(?: (?:=|>) ?\\'(.*)')";
    private final String currency = "(?:translate\\(.*\\, \\'([A-z,#&0-9; ]+)\\')";

    @Override
    public Map<String, String> readFromXsl(String xsl) {
        List<String> fileLineByLine = splitToLine(xsl);

        List<String> structureXsl = fileLineByLine.stream()
                .map(line -> resolveValues(line, structure))

                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> standardKey = fileLineByLine.stream()
                .map(line -> resolveValues(line, classicKey))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> numericKeyInNumberLine = fileLineByLine.stream()
                .map(line -> resolveBooleanValues(line, keyInNumericLine))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> numericValuesInNumberLine = fileLineByLine.stream()
                .map(line -> resolveBooleanValues(line, valueInNumericLine))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> currency = fileLineByLine.stream()
                .map(line -> resolveValues(line, this.currency))
                .flatMap(List::stream)
                .findFirst().stream().toList();

        Map<String, String> structureFile = addKeys(structureXsl, structureList);
        Map<String, String> standardKeys = addKeys(standardKey, classicKeyList);
        Map<String, String> numericKeys = addKeys(numericKeyInNumberLine, numericKeyList);
        Map<String, String> valuesKeys = addKeysInNumeric(numericValuesInNumberLine, numericValueList);
        Map<String, String> currencyKey = addKeys(currency, currencyList);
        return resolveValuesAndKeys(standardKeys, numericKeys, valuesKeys, currencyKey, structureFile);
    }

    @Override
    public Map<String, String> resolveValuesAndKeys(Map<String, String> structureFile,
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
                if(element.equalsIgnoreCase("UNDEFINED")){
                    element = "";
                }
                elements.add(element);
            }
        }
        return elements;
    }

    private List<String> resolveBooleanValues(String xsl, String pattern) {
        List<String> elements = new ArrayList<>();
        if(xsl.contains("<xsl:when test=\\\"UNDEFINED\\\"")){
            elements.add("");
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(xsl);
        while (m.find()) {
            if (m.group(1) != null) {
                String element = m.group(1);
                if(element.equalsIgnoreCase("UNDEFINED")){
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
            if(key.get(i).equals("UNDEFINED")){
                emptyMap.put(values.get(i), " ");
            } else {
                emptyMap.put(values.get(i), key.get(i));
            }

        }
        return emptyMap;
    }

    private boolean resolveStructure(String structure) {
        if (structure.equals(listOfAvailableStructure)) {
            return true;
        }
        return false;
    }

}

