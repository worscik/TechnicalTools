package pl.technicalsite.FileComponents.CutLine;

import org.springframework.stereotype.Component;

import static pl.technicalsite.FileModel.MappingsType.*;

@Component
public class CutLine {

    public String resolveCutLine(String structure){
        switch (structure) {
            case RRS_CHANNEL_ITEM -> {
                return "rrs - Headers";
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
