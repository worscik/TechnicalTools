package pl.technicalsite.FileComponents;

import org.springframework.stereotype.Service;

import java.util.Objects;

import static pl.technicalsite.FieldsModel.StandardMappingsType.*;

@Service
public class CutLineService {

    public String resolveCutLine(String cutLine) {
        if (Objects.isNull(cutLine)) {
            return " ";
        }
        switch (cutLine) {
            case ROOT_ITEM, OFFERS_GROUP_O, PRODUCTS_PRODUCT -> {
                return "";
            }
            case RSS_CHANNEL_ITEM -> {
                return "<xsl:template match=\"rss/channel/title | rss/channel/link | rss/channel/description\"/>";
            }
            case FEED_ENTRY -> {
                return "<xsl:template match=\"a:feed/a:title | a:feed/a:link | a:feed/a:updated\" />";
            }
            default -> {
                return splitValues(cutLine);
            }
        }
    }

    private String splitValues(String cutLine) {
        String replacedString = cutLine.replaceAll(",", " | ");
        return "<xsl:template match=\"" + replacedString + "\"/>";
    }

}
