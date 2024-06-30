package pl.technicalsite.FileService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.technicalsite.FieldsModel.*;
import pl.technicalsite.FileComponents.CutLineService;
import pl.technicalsite.FileComponents.HeadersService;
import pl.technicalsite.FileComponents.MatchLineService;
import pl.technicalsite.TemplateModel.TemplateComponentsDto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FileServiceImplTest {

    private final String CUT_LINE = "";
    private final String MATCH_LINE = "<xsl:template match=\"root/item\">";
    private final String HEADERS = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">";
    private final String STRUCTURE = "root/item";

    @Mock
    private CutLineService cutLineService;
    @Mock
    private HeadersService headersService;
    @Mock
    private MatchLineService matchLineService;
    @Mock
    private TemplateServiceImpl templateServiceImpl;
    @Mock
    private TemplateFieldsMapper templateFieldsMapper;
    @Mock
    private StandardMappingsType standardMappingsType;
    @InjectMocks
    private FileServiceImpl fileService;


    @Test
    void createFileSuccessWithStandardStructure() {
        when(standardMappingsType.resolveStructure(any())).thenReturn(true);
        FileBasicRequest fileBasicRequest = new FileBasicRequest(STRUCTURE, createFieldsDto());
        FileResponse expected = fileService.createFile(fileBasicRequest);

        assertThat(fileService.createFile(fileBasicRequest).getResult())
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo(expected.getResult());
    }

    @Test
    void createFileSuccessWithCustomStructure() {
        when(standardMappingsType.resolveStructure(any())).thenReturn(false);
        FileBasicRequest fileBasicRequest = new FileBasicRequest(STRUCTURE, createFieldsDto());
        FileResponse expected = fileService.createFile(fileBasicRequest);

        assertThat(fileService.createFile(fileBasicRequest).getResult())
                .isNotNull()
                .usingDefaultComparator()
                .isEqualTo(expected.getResult());
    }

    @Test
    void createFileFailed() {
        when(standardMappingsType.resolveStructure(any())).thenReturn(true);
        when(templateServiceImpl.createTemplate(any(),any())).thenThrow(NullPointerException.class);
        FileBasicRequest fileBasicRequest = new FileBasicRequest(STRUCTURE, createFieldsDto());
        FileResponse fileResponse = fileService.createFile(fileBasicRequest);
        assertThat(fileResponse.getResult())
                .usingDefaultComparator()
                .isEqualTo(null);
    }

    private TemplateComponentsDto buildComponents(boolean isStandardStructure) {
        return new TemplateComponentsDto.Builder()
                .structure(STRUCTURE)
                .headers(HEADERS)
                .cutLine(isStandardStructure
                        ? cutLineService.resolveCutLine(STRUCTURE)
                        : cutLineService.resolveCutLine(CUT_LINE))
                .matchLine(MATCH_LINE)
                .build();
    }

    public static FieldsDto createFieldsDto() {
        FieldsDto fieldsDto = new FieldsDto();
        fieldsDto.setId("test_id");
        fieldsDto.setName("Test Product");
        fieldsDto.setNewProductKey("newKey");
        fieldsDto.setNewProductValue("newValue");
        fieldsDto.setAvailableKey("availableKey");
        fieldsDto.setAvailableValue("availableValue");
        fieldsDto.setBestsellerKey("bestsellerKey");
        fieldsDto.setBestsellerValue("bestsellerValue");
        fieldsDto.setBrand("Test Brand");
        fieldsDto.setCategories("Test Category");
        fieldsDto.setCategoryMain("Main Category");
        fieldsDto.setDescription("This is a test fieldsDto description.");
        fieldsDto.setDetail1("Detail 1");
        fieldsDto.setDetail2("Detail 2");
        fieldsDto.setDetail3("Detail 3");
        fieldsDto.setDetail4("Detail 4");
        fieldsDto.setDetail5("Detail 5");
        fieldsDto.setManufacturer("Test Manufacturer");
        fieldsDto.setPrice("100.00");
        fieldsDto.setCurrency("USD");
        fieldsDto.setPricePromo("80.00");
        fieldsDto.setQuantity("10");
        fieldsDto.setUrlProduct("http://testproduct.com");
        fieldsDto.setUrlImg("http://testproduct.com/img.jpg");
        fieldsDto.setGenderKey("genderKey");
        fieldsDto.setGenderValue("genderValue");
        fieldsDto.setUrlCategory("http://testcategory.com");
        fieldsDto.setUrlCategoryMark("http://testcategorymark.com");
        fieldsDto.setPopularity("5");
        fieldsDto.setSeason("Summer");
        fieldsDto.setColor("Red");
        fieldsDto.setAdditionalImage("http://testproduct.com/additional_img.jpg");
        fieldsDto.setIntDetail1("1");
        fieldsDto.setIntDetail2("2");
        fieldsDto.setIntDetail3("3");
        return fieldsDto;
    }

    private FieldsBuilder buildFieldsBuilder(){
        return new FieldsBuilder.Builder()
                .id("12345")
                .name("Sample Product")
                .newProductKey("newProduct")
                .newProductValue("true")
                .availableKey("available")
                .availableValue("in stock")
                .bestsellerKey("bestseller")
                .bestsellerValue("true")
                .brand("Sample Brand")
                .categories("Category1, Category2")
                .categoryMain("Main Category")
                .description("This is a sample product description.")
                .detail1("Detail 1 value")
                .detail2("Detail 2 value")
                .detail3("Detail 3 value")
                .detail4("Detail 4 value")
                .detail5("Detail 5 value")
                .manufacturer("Sample Manufacturer")
                .price("19.99")
                .currency("USD")
                .pricePromo("14.99")
                .quantity("100")
                .urlProduct("http://example.com/product")
                .urlImg("http://example.com/image.jpg")
                .genderKey("gender")
                .genderValue("unisex")
                .urlCategory("http://example.com/category")
                .urlCategoryMark("http://example.com/categoryMark")
                .popularity("high")
                .season("Summer")
                .color("Red")
                .additionalImage("http://example.com/additionalImage.jpg")
                .intDetail1("Internal Detail 1")
                .intDetail2("Internal Detail 2")
                .intDetail3("Internal Detail 3")
                .build();
    }

}