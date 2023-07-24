package pl.technicalsite.FileComponents.CutLine;

import org.springframework.stereotype.Component;

import static pl.technicalsite.FileModel.MappingsType.*;

@Component
public class CutLineService {

    public String resolveCutLine(String structure){
        switch (structure) {
            case RSS_CHANNEL_ITEM -> {
                return "rss - Headers";
            }
            case ROOT_ITEM -> {
                return "root - Headers";
            }
            case PRODUCTS_PRODUCT -> {
                return "products - Headers";
            }
        }
        return null;
    }

}
