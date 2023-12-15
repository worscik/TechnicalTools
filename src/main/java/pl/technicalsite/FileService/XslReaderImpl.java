package pl.technicalsite.FileService;

import org.springframework.stereotype.Service;
import pl.technicalsite.FileModel.MappingsType;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static pl.technicalsite.FileModel.MappingsType.listOfAvailableStructure;

@Service
public class XslReaderImpl implements XslReader {

    private List<String> structureList = List.of("structure");
    private List<String> standardValueList = List.of("id", "name",
            "brand", "categories", "categoryMain", "description", "detail1",
            "detail2", "detail3", "detail4", "detail5", "manufacturer", "price", "pricePromo", "quantity",
            "urlProduct", "urlImg", "urlCategory", "urlCategoryMark", "popularity", "season",
            "color", "addidtionalImage");
    private List<String> numericValueList = List.of("newProductKey", "availableKey", "bestsellerKey", "genderKey");
    private List<String> valuesList = List.of("newProductValue", "availableValue", "bestsellerValue", "genderValue");
    private List<String> currencyList = List.of("currency");

    private final String structureRegex = "(?:template.match\\=\\\\\\\"([A-z\\/]+)\\\\)";
    private final String regexStandardValue = "(?:test=\\\\\\\"[a-z-]+\\((.*)\\))";
    private final String regexNumericValue = "(?:test=\\\\\\\"(.*).\\=)";
    private final String regexValue = "(?:test=\\\\?\\\"[A-z:]+.?=.?\\'(.*)\\')";
    private final String regexCurrency = "(?:translate\\([A-z0-9:,]+.'.?(.*)',)";


    @Override
    public Map<String, String> readFromXsl(String xsl) {
        List<String> fileLineByLine = splitToLine(xsl);

        List<String> structure = fileLineByLine.stream()
                .map(line -> resolveValues(line, structureRegex))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> keyStandard = fileLineByLine.stream()
                .map(line -> resolveValues(line, regexStandardValue))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> keyNumeric = fileLineByLine.stream()
                .map(line -> resolveValues(line, regexNumericValue))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> values = fileLineByLine.stream()
                .map(line -> resolveValues(line, regexValue))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> currency = fileLineByLine.stream()
                .map(line -> resolveValues(line, regexCurrency))
                .flatMap(List::stream)
                .findFirst().stream().toList();

        Map<String, String> structureFile = addKeys(structure, structureList);
        Map<String, String> standardKeys = addKeys(keyStandard, standardValueList);
        Map<String, String> numericKeys = addKeys(keyNumeric, numericValueList);
        Map<String, String> valuesKeys = addKeys(values, valuesList);
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
                elements.add(element);
            }
        }
        return elements;
    }


    private List<String> splitToLine(String xsl) {
        List<String> file = new ArrayList<>();
        String[] lines = xsl.split(">");
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

    private boolean resolveStructure(String structure){
        if(structure.equals(listOfAvailableStructure)){
            return true;
        }
        return false;
    }

}

