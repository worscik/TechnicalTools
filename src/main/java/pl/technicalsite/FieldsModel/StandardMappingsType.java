package pl.technicalsite.FieldsModel;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StandardMappingsType {

    public static final String RSS_CHANNEL_ITEM = "rss/channel/item";
    public static final String ROOT_ITEM = "root/item";
    public static final String PRODUCTS_PRODUCT = "products/product";
    public static final String FEED_ENTRY = "feed/entry";
    public static final String OFFERS_GROUP_O = "offers/group/o";

    public static List<String> listOfAvailableStructure = List.of(RSS_CHANNEL_ITEM, ROOT_ITEM, PRODUCTS_PRODUCT, FEED_ENTRY, OFFERS_GROUP_O);

    public boolean resolveStructure(String structure) {
        for (String x : listOfAvailableStructure) {
            if (x.equals(structure)) {
                return true;
            }
        }
        return false;
    }

}
