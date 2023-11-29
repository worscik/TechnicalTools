package pl.technicalsite.FileComponents.Headers;

import org.springframework.stereotype.Component;
import pl.technicalsite.FileModel.MappingsType;

@Component
public class HeadersService {

    public String resolveHeaders(String structure) {
        switch (structure) {
            case MappingsType.ROOT_ITEM, MappingsType.OFFERS_GROUP_O, MappingsType.PRODUCTS_PRODUCT -> {
                return "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">";
            }
            case MappingsType.RSS_CHANNEL_ITEM -> {
                return "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"\n" +
                        "\t\txmlns:g=\"http://base.google.com/ns/1.0\">";
            }
            case MappingsType.FEED_ENTRY -> {
                return "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"\n" +
                        "\t\txmlns:g=\"http://base.google.com/ns/1.0\"\n" +
                        "\t\txmlns:a=\"http://www.w3.org/2005/Atom\">";
            }
        }
        return null;
    }

}