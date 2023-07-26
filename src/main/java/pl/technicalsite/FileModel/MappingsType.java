package pl.technicalsite.FileModel;

import java.util.List;

public class MappingsType {

    public static final String RSS_CHANNEL_ITEM = "rss/channel/item";
    public static final String ROOT_ITEM = "root/item";
    public static final String PRODUCTS_PRODUCT = "products/product";
    public static final String FEED_ENTRY = "feed/entry";
    public static final String OFFERS_GROUP_O = "offers/group/o";

    public static List<String> listOfAvailableStructure = List.of(RSS_CHANNEL_ITEM, ROOT_ITEM, PRODUCTS_PRODUCT, FEED_ENTRY, OFFERS_GROUP_O);

}
