package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.technicalsite.FileComponents.CutLine.CutLineService;
import pl.technicalsite.FileComponents.Headers.HeadersService;
import pl.technicalsite.FileComponents.MatchLine.MatchLineService;
import pl.technicalsite.FileComponents.Structure.StructureFile;
import pl.technicalsite.FileModel.FieldsBuilder;
import pl.technicalsite.FileModel.FieldsDto;
import pl.technicalsite.FileModel.FileCustomDto;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.Template.TemplateModel.TemplateComponents;
import pl.technicalsite.Template.TemplateService.TemplateService;

@Service
public class FileService implements IFileService {

    private static final Logger logger = LogManager.getLogger(FileService.class);
    private final CutLineService cutLineService;
    private final HeadersService headersService;
    private final StructureFile structureFile;
    private final MatchLineService matchLineService;
    private final TemplateService templateService;

    public FileService(CutLineService cutLineService, HeadersService headersService,
                       StructureFile structureFile, MatchLineService matchLineService,
                       TemplateService templateService) {
        this.cutLineService = cutLineService;
        this.headersService = headersService;
        this.structureFile = structureFile;
        this.matchLineService = matchLineService;
        this.templateService = templateService;
    }

    private boolean checkStructure(String structure, boolean isCustom) {
        if (isCustom) {
            logger.info("used custom flag");
            return true;
        }
        return structureFile.resolveStructure(structure);
    }

    private TemplateComponents buildCustomComponentsTemplate(String structure, boolean isCustom, FileCustomDto fileCustomDto) {
        return new TemplateComponents.Builder()
                .structure(structure)
                .headers(headersService.reseolveHeaders(structure))
                .cutLine(cutLineService.resolveCustomMatchLine(structure, fileCustomDto.getCutLine()))
                .matchLine(matchLineService.resolveCustomMatchLine(structure, fileCustomDto.getCustomMatchLine()))
                .build();
    }

    private TemplateComponents buildStandardComponentsTemplate(String structure) {
        return new TemplateComponents.Builder()
                .structure(structure)
                .headers(headersService.reseolveHeaders(structure))
                .cutLine(cutLineService.resolveStandardCutLine(structure))
                .matchLine(matchLineService.resolveStandardMatchLine(structure))
                .build();
    }

    @Override
    public String preapreStandardFile(FileDto fileDto, FileCustomDto fileCustomDto) {
        if (!checkStructure(fileDto.getStructure(), fileDto.isCustom())) {
            logger.info("Structure is not correct");
            return "Structure is not correct";
        }
        try {
            String structure = fileDto.getStructure();
            TemplateComponents templateComponents = buildStandardComponentsTemplate(structure);
            FieldsBuilder fileFields = biuldFileFields(fileDto.getFieldsDto());
            return createFile(templateComponents, fileFields);
        } catch (Exception e) {
            logger.error(e);
            return "error..";
        }
    }

    @Override
    public String prepareCustomFile(FileDto fileDto, FileCustomDto fileCustomDto) {
        try {
            String structure = fileDto.getStructure();
            TemplateComponents templateComponents = buildCustomComponentsTemplate(structure, fileDto.isCustom(), fileCustomDto);
            FieldsBuilder fileFields = biuldFileFields(fileDto.getFieldsDto());
            return templateService.createFile(templateComponents, fileFields);
        } catch (Exception e) {
            logger.error(e);
            return "error..";
        }
    }

    @Override
    public String createFile(TemplateComponents templateComponents, FieldsBuilder fieldsBuilder) {
        return templateService.createFile(templateComponents, fieldsBuilder);
    }

    private FieldsBuilder biuldFileFields(FieldsDto field) {
        try{
            return new FieldsBuilder.Builder()
                    .id(field.getId())
                    .name(resolveEmptyField(field.getName()))
                    .newProductKey(resolveEmptyField(field.getNewProductKey()))
                    .newProductValue(resolveEmptyField(field.getNewProductValue()))
                    .availableKey(resolveEmptyField(field.getAvailableKey()))
                    .availableValue(resolveEmptyField(field.getAvailableValue()))
                    .bestsellerKey(resolveEmptyField(field.getBestsellerKey()))
                    .bestsellerValue(resolveEmptyField(field.getBestsellerValue()))
                    .brand(resolveEmptyField(field.getBrand()))
                    .categories(resolveEmptyField(field.getCategories()))
                    .categoryMain(resolveEmptyField(field.getCategoryMain()))
                    .description(resolveEmptyField(field.getDescription()))
                    .detail1(resolveEmptyField(field.getDetail1()))
                    .detail2(resolveEmptyField(field.getDetail2()))
                    .detail3(resolveEmptyField(field.getDetail3()))
                    .detail4(resolveEmptyField(field.getDetail4()))
                    .detail5(resolveEmptyField(field.getDetail5()))
                    .manufacturer(resolveEmptyField(field.getManufacturer()))
                    .price(field.getPrice())
                    .currency(field.getCurrency())
                    .pricePromo(resolveEmptyField(field.getPricePromo()))
                    .quantity(resolveEmptyField(field.getQuantity()))
                    .urlProduct(resolveEmptyField(field.getUrlProduct()))
                    .urlImg(resolveEmptyField(field.getUrlImg()))
                    .genderKey(resolveEmptyField(field.getGenderKey()))
                    .genderValue(resolveEmptyField(field.getGenderValue()))
                    .urlCategory(resolveEmptyField(field.getUrlCategory()))
                    .urlCategoryMark(resolveEmptyField(field.getUrlCategoryMark()))
                    .popularity(resolveEmptyField(field.getPopularity()))
                    .season(resolveEmptyField(field.getSeason()))
                    .color(resolveEmptyField(field.getColor()))
                    .addidtionalImage(resolveEmptyField(field.getAddidtionalImage()))
                    .intDetail1(resolveEmptyField(field.getIntDetail1()))
                    .intDetail2(resolveEmptyField(field.getIntDetail2()))
                    .intDetail3(resolveEmptyField(field.getIntDetail3()))
                    .build();
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static String resolveEmptyField(String value) {
        if (value == "" || value == null) {
            return "UNDEFINED";
        }
        return value;
    }

}