package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.technicalsite.FileComponents.CutLineService;
import pl.technicalsite.FileComponents.HeadersService;
import pl.technicalsite.FileComponents.MatchLineService;
import pl.technicalsite.FileModel.FieldsBuilder;
import pl.technicalsite.FileModel.FieldsDto;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileResponse;
import pl.technicalsite.FileModel.Template.TemplateComponentsDto;

import java.util.List;
import java.util.Optional;

import static pl.technicalsite.FileModel.MappingsType.listOfAvailableStructure;


@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);
    private final CutLineService cutLineService;
    private final HeadersService headersService;
    private final MatchLineService matchLineService;
    private final TemplateService templateService;

    public FileServiceImpl(CutLineService cutLineService, HeadersService headersService,
                           MatchLineService matchLineService,
                           TemplateService templateService) {
        this.cutLineService = cutLineService;
        this.headersService = headersService;
        this.matchLineService = matchLineService;
        this.templateService = templateService;
    }

    private TemplateComponentsDto buildStandardComponentsTemplate(FileDto fileDto) {
        return new TemplateComponentsDto.Builder()
                .structure(fileDto.getStructure())
                .headers(headersService.resolveHeaders(fileDto.getStructure()))
                .cutLine(cutLineService.resolveCutLine(fileDto.getStructure()))
                .matchLine(matchLineService.resolveMatchLine(fileDto.getStructure()))
                .build();
    }

    private TemplateComponentsDto buildCustomComponentsTemplate(FileDto fileDto) {
        return new TemplateComponentsDto.Builder()
                .structure(fileDto.getStructure())
                .headers(headersService.resolveHeaders(fileDto.getStructure()))
                .cutLine(cutLineService.resolveCutLine(fileDto.getCutLine()))
                .matchLine(matchLineService.resolveMatchLine(fileDto.getStructure()))
                .build();
    }

    @Override
    public Optional<FileResponse> createFile(FileDto fileDto) {
        boolean isStandard = resolveStructure(fileDto.getStructure().toLowerCase());
        try {
            TemplateComponentsDto templateComponentsDto = isStandard
                    ? buildStandardComponentsTemplate(fileDto)
                    : buildCustomComponentsTemplate(fileDto);
            Optional<FieldsBuilder> fileFields = buildFileFields(fileDto.getFieldsDto());
            String file = createFile(templateComponentsDto, fileFields.get());
            return Optional.of(new FileResponse(file, List.of("")));
        } catch (Exception e) {
            logger.error("An error occurred while building the file", e);
            return Optional.of(new FileResponse("", List.of("An error occurred while building the file.")));
        }
    }

    private String createFile(TemplateComponentsDto templateComponentsDto, FieldsBuilder fieldsBuilder) {
        return templateService.createFile(templateComponentsDto, fieldsBuilder);
    }

    private Optional<FieldsBuilder> buildFileFields(FieldsDto field) {
        try {
            return Optional.of(new FieldsBuilder.Builder()
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
                    .price(resolveEmptyField(field.getPrice()))
                    .currency(field.getCurrency())
                    .pricePromo(resolveEmptyField(field.getPrice()))
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
                    .build());
        } catch (Exception e) {
            logger.error("An unexpected error occurred during build object", e);
            return Optional.empty();
        }
    }

    public static String resolveEmptyField(String value) {
        if (value.isEmpty()) {
            return "UNDEFINED";
        }
        return value;
    }

    private boolean resolveStructure(String structure) {
        for (String x : listOfAvailableStructure) {
            if (x.equals(structure)) {
                return true;
            }
        }
        return false;
    }

}