package pl.technicalsite.FileComponents.Headers;

import org.springframework.stereotype.Component;

import static pl.technicalsite.FileModel.MappingsType.*;

@Component
public class HeadersService {

    public String reseolveHeaders(String structure){
        switch (structure) {
            case RRS_CHANNEL_ITEM -> {
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
