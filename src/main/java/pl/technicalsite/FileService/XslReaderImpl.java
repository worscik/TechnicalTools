package pl.technicalsite.FileService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class XslReaderImpl implements XslReader {

    private String[] xslKeyStandard = new String[]{"id", "name", "newProductKey", "availableKey",
            "bestsellerKey", "brand", "categories", "categoryMain", "description", "detail1",
            "detail2", "detail3", "detail4", "detail5", "manufacturer", "price", "pricePromo", "quantity",
            "urlProduct", "urlImg", "genderKey", "urlCategory", "urlCategoryMark", "popularity", "season",
            "color", "addidtionalImage", "intDetail1", "intDetail2", "intDetail3",};
    private String[] xslValue = new String[]{"newProductValue", "availableValue", "bestsellerValue", "genderValue"};
    private String[] xslPriceValues = new String[]{"currency"};

    private final String regexStandardValue = "(?:test=\\\"string-length\\((.*)\\)\\\")";
    private final String regexKey = "(?:test=\\\"(.*).=)";
    private final String regexValue = "(?:test=\\\"[A-z0-9]+.?=.?\\'(.*)\\')";
    private final String regexCurrency = "(?:translate\\([A-z0-9:,]+.'(.*)',)";


    @Override
    public Map<String, String> readFromXsl(String xsl) {
        try {
            Map<String, String> listOfKeys = resolveStandardKeys(xsl);
            Map<String, String> listOfValues = resolveValues(xsl);
            Map<String, String> listCurrency = resolvePriceCurrency(xsl);
            return createMapWithKeysAndValues(listOfKeys, listOfValues, listCurrency);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public Map<String, String> createMapWithKeysAndValues(Map<String, String> keys,
                                                          Map<String, String> values,
                                                          Map<String, String> currency) {
        Map<String, String> list = new HashMap<>();
        list.putAll(keys);
        list.putAll(values);
        list.putAll(currency);
        return list;

    }

    private Map<String, String> resolveStandardKeys(String xsl) {
        Map<String, String> values = new HashMap<>();
        Pattern p = Pattern.compile(regexStandardValue + "|" + regexKey);
        Matcher m = p.matcher(xsl);
        int counter = 0;
        while (m.find()) {
            if (m.group(1) != null) {
                String element1 = m.group(1);
                System.out.println("StandardKey: " + element1);
                values.put(xslKeyStandard[counter], element1);
                counter++;
            } else if (m.group(2) != null) {
                String element2 = m.group(2);
                System.out.println("StandardKey: " + element2);
                values.put(xslKeyStandard[counter], element2);
                counter++;
            }
        }
        return values;
    }

    private Map<String, String> resolveValues(String xsl) {
        Map<String, String> values = new HashMap<>();
        Pattern p = Pattern.compile(regexValue);
        Matcher m = p.matcher(xsl);
        int counter = 0;
        while (m.find()) {
            String element1 = m.group(1);
            System.out.println("StandardValues: " + xslValue[counter] + " " + element1);
            values.put(xslValue[counter], element1);
            counter++;
        }
        return values;
    }

    private Map<String, String> resolvePriceCurrency(String xsl) {
        Map<String, String> priceValues = new HashMap<>();
        Pattern p = Pattern.compile(regexCurrency);
        Matcher m = p.matcher(xsl);
        while (m.find()) {
            String element = m.group(1);
            System.out.println("Currency: " + xslPriceValues[0] + " " + element);
            priceValues.put(xslPriceValues[0], element);
        }
        return priceValues;
    }

}

