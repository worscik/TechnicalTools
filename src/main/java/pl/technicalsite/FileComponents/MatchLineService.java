package pl.technicalsite.FileComponents;

import org.springframework.stereotype.Component;

import java.util.Objects;

import static pl.technicalsite.FileModel.MappingsType.*;

@Component
public class MatchLineService {

    public String resolveMatchLine(String matchLine) {
        switch (matchLine) {
            case RSS_CHANNEL_ITEM -> {
                return "<xsl:template match=\"rss/channel/item\">";
            }
            case ROOT_ITEM -> {
                return "<xsl:template match=\"root/item\">";
            }
            case PRODUCTS_PRODUCT -> {
                return "<xsl:template match=\"products/product\">";
            }
            case FEED_ENTRY -> {
                return "<xsl:template match=\"a:feed/a:entry\">";
            }
            case OFFERS_GROUP_O -> {
                return "<xsl:template match=\"offers/group/o\">";
            }
            default -> {
                return splitValues(matchLine);
            }
        }
    }

    private String splitValues(String cutLine) {
        String replacedString = cutLine.replaceAll(",", " | ");
        return "<xsl:template match=\"" + replacedString + "\">";
    }


}
