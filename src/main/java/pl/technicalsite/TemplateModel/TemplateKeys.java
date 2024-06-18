package pl.technicalsite.TemplateModel;

import java.util.List;

public class TemplateKeys {

    public static final List<String> structureList = List.of("structure");
    public static final List<String> classicKeyList = List.of("id", "name",
            "brand", "categories", "categoryMain", "description", "detail1",
            "detail2", "detail3", "detail4", "detail5", "manufacturer", "price", "pricePromo", "quantity",
            "urlProduct", "urlImg", "urlCategory", "urlCategoryMark", "popularity", "season",
            "color", "addidtionalImage");
    public static final List<String> numericKeyList = List.of("newProductKey", "availableKey", "bestsellerKey", "genderKey");
    public static final List<String> numericValueList = List.of("newProductValue", "availableValue", "bestsellerValue", "genderValue");
    public static final List<String> currencyList = List.of("currency");
    public static final List<String> customCutLineList = List.of("cutLine","matchLine");

}
