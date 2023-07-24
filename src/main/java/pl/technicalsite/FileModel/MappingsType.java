package pl.technicalsite.FileModel;

import java.util.List;

public class MappingsType {

    public static final String RSS_CHANNEL_ITEM = "rss/channel/item";
    public static final String ROOT_ITEM = "root/item";
    public static final String PRODUCTS_PRODUCT = "products/product";


    public static List<String> listOfAvailableStructure = List.of(RSS_CHANNEL_ITEM, ROOT_ITEM, PRODUCTS_PRODUCT);

}
