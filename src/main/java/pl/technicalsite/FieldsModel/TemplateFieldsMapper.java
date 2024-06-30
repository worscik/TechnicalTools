package pl.technicalsite.FieldsModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import pl.technicalsite.FileService.FileServiceImpl;

import java.util.Objects;

@Component
public class TemplateFieldsMapper {

    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    public FieldsBuilder buildFileFields(FieldsDto field) {
        try {
            return new FieldsBuilder.Builder()
                    // Id is required
                    .id(field.getId())
                    .name(setUndefinedIfEmpty(field.getName()))
                    .newProductKey(setUndefinedIfEmpty(field.getNewProductKey()))
                    .newProductValue(setUndefinedIfEmpty(field.getNewProductValue()))
                    .availableKey(setUndefinedIfEmpty(field.getAvailableKey()))
                    .availableValue(setUndefinedIfEmpty(field.getAvailableValue()))
                    .bestsellerKey(setUndefinedIfEmpty(field.getBestsellerKey()))
                    .bestsellerValue(setUndefinedIfEmpty(field.getBestsellerValue()))
                    .brand(setUndefinedIfEmpty(field.getBrand()))
                    .categories(setUndefinedIfEmpty(field.getCategories()))
                    .categoryMain(setUndefinedIfEmpty(field.getCategoryMain()))
                    .description(setUndefinedIfEmpty(field.getDescription()))
                    .detail1(setUndefinedIfEmpty(field.getDetail1()))
                    .detail2(setUndefinedIfEmpty(field.getDetail2()))
                    .detail3(setUndefinedIfEmpty(field.getDetail3()))
                    .detail4(setUndefinedIfEmpty(field.getDetail4()))
                    .detail5(setUndefinedIfEmpty(field.getDetail5()))
                    .manufacturer(setUndefinedIfEmpty(field.getManufacturer()))
                    .price(setUndefinedIfEmpty(field.getPrice()))
                    .currency(field.getCurrency())
                    .pricePromo(setUndefinedIfEmpty(field.getPrice()))
                    .quantity(setUndefinedIfEmpty(field.getQuantity()))
                    .urlProduct(setUndefinedIfEmpty(field.getUrlProduct()))
                    .urlImg(setUndefinedIfEmpty(field.getUrlImg()))
                    .genderKey(setUndefinedIfEmpty(field.getGenderKey()))
                    .genderValue(setUndefinedIfEmpty(field.getGenderValue()))
                    .urlCategory(setUndefinedIfEmpty(field.getUrlCategory()))
                    .urlCategoryMark(setUndefinedIfEmpty(field.getUrlCategoryMark()))
                    .popularity(setUndefinedIfEmpty(field.getPopularity()))
                    .season(setUndefinedIfEmpty(field.getSeason()))
                    .color(setUndefinedIfEmpty(field.getColor()))
                    .additionalImage(setUndefinedIfEmpty(field.getAdditionalImage()))
                    .intDetail1(setUndefinedIfEmpty(field.getIntDetail1()))
                    .intDetail2(setUndefinedIfEmpty(field.getIntDetail2()))
                    .intDetail3(setUndefinedIfEmpty(field.getIntDetail3()))
                    .build();
        } catch (Exception e) {
            logger.error("An unexpected error occurred during build object", e);
            return null;
        }
    }

    public static String setUndefinedIfEmpty(String value) {
        if (value.isEmpty() || Objects.isNull(value)) {
            return "UNDEFINED";
        }
        return value;
    }

}
