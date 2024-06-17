package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.technicalsite.FileModel.FieldsBuilder;
import pl.technicalsite.FileModel.FieldsDto;

public class TemplateFieldsMapper {

    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    public FieldsBuilder buildFileFields(FieldsDto field) {
        try {
            return new FieldsBuilder.Builder()
                    .id(field.getId())
                    .name(checkIfEmpty(field.getName()))
                    .newProductKey(checkIfEmpty(field.getNewProductKey()))
                    .newProductValue(checkIfEmpty(field.getNewProductValue()))
                    .availableKey(checkIfEmpty(field.getAvailableKey()))
                    .availableValue(checkIfEmpty(field.getAvailableValue()))
                    .bestsellerKey(checkIfEmpty(field.getBestsellerKey()))
                    .bestsellerValue(checkIfEmpty(field.getBestsellerValue()))
                    .brand(checkIfEmpty(field.getBrand()))
                    .categories(checkIfEmpty(field.getCategories()))
                    .categoryMain(checkIfEmpty(field.getCategoryMain()))
                    .description(checkIfEmpty(field.getDescription()))
                    .detail1(checkIfEmpty(field.getDetail1()))
                    .detail2(checkIfEmpty(field.getDetail2()))
                    .detail3(checkIfEmpty(field.getDetail3()))
                    .detail4(checkIfEmpty(field.getDetail4()))
                    .detail5(checkIfEmpty(field.getDetail5()))
                    .manufacturer(checkIfEmpty(field.getManufacturer()))
                    .price(checkIfEmpty(field.getPrice()))
                    .currency(field.getCurrency())
                    .pricePromo(checkIfEmpty(field.getPrice()))
                    .quantity(checkIfEmpty(field.getQuantity()))
                    .urlProduct(checkIfEmpty(field.getUrlProduct()))
                    .urlImg(checkIfEmpty(field.getUrlImg()))
                    .genderKey(checkIfEmpty(field.getGenderKey()))
                    .genderValue(checkIfEmpty(field.getGenderValue()))
                    .urlCategory(checkIfEmpty(field.getUrlCategory()))
                    .urlCategoryMark(checkIfEmpty(field.getUrlCategoryMark()))
                    .popularity(checkIfEmpty(field.getPopularity()))
                    .season(checkIfEmpty(field.getSeason()))
                    .color(checkIfEmpty(field.getColor()))
                    .addidtionalImage(checkIfEmpty(field.getAddidtionalImage()))
                    .intDetail1(checkIfEmpty(field.getIntDetail1()))
                    .intDetail2(checkIfEmpty(field.getIntDetail2()))
                    .intDetail3(checkIfEmpty(field.getIntDetail3()))
                    .build();
        } catch (Exception e) {
            logger.error("An unexpected error occurred during build object", e);
            return new FieldsBuilder.Builder().build();
        }
    }

    public static String checkIfEmpty(String value) {
        if (value.isEmpty()) {
            return "UNDEFINED";
        }
        return value;
    }

}
