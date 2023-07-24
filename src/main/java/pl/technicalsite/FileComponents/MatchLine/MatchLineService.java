package pl.technicalsite.FileComponents.MatchLine;

import org.springframework.stereotype.Component;

import static pl.technicalsite.FileModel.MappingsType.*;

@Component
public class MatchLineService {

    public String resolveMatchLine(String structure){
        switch (structure) {
            case RSS_CHANNEL_ITEM -> {
                return "rss - matchLine";
            }
            case ROOT_ITEM -> {
                return "root - matchLine";
            }
            case PRODUCTS_PRODUCT -> {
                return "products - matchLine";
            }

        }
        return null;
    }

}
