package pl.technicalsite.FileComponents.CutLine;

import org.springframework.stereotype.Component;

import static pl.technicalsite.FileModel.MappingsType.*;

@Component
public class CutLineService {

    public String resolveCutLine(String structure) {
        switch (structure) {
            case ROOT_ITEM, OFFERS_GROUP_O, PRODUCTS_PRODUCT -> {
                return "";
            }
            case RSS_CHANNEL_ITEM -> {
                return "<xsl:template match=\"rss/channel/title | rss/channel/link | rss/channel/description\"/>";
            }

            case FEED_ENTRY -> {
                return "<xsl:template match=\"a:feed/a:title | a:feed/a:link | a:feed/a:updated\" />";
            }
        }
        return null;
    }

}
