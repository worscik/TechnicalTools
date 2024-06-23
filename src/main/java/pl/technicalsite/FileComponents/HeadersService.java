package pl.technicalsite.FileComponents;

import org.springframework.stereotype.Component;
import pl.technicalsite.FieldsModel.StandardMappingsType;

@Component
public class HeadersService {

    public String resolveHeaders(String structure) {
        switch (structure) {
            case StandardMappingsType.ROOT_ITEM, StandardMappingsType.OFFERS_GROUP_O,
                 StandardMappingsType.PRODUCTS_PRODUCT -> {
                return "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">";
            }
            case StandardMappingsType.RSS_CHANNEL_ITEM -> {
                return "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"\n" +
                        "\t\txmlns:g=\"http://base.google.com/ns/1.0\">";
            }
            case StandardMappingsType.FEED_ENTRY -> {
                return "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"\n" +
                        "\t\txmlns:g=\"http://base.google.com/ns/1.0\"\n" +
                        "\t\txmlns:a=\"http://www.w3.org/2005/Atom\">";
            }
            default -> {
                return "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">";
            }
        }
    }

}