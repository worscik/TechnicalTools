package pl.technicalsite.FileService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.technicalsite.FieldsModel.FieldsBuilder;
import pl.technicalsite.TemplateModel.Template;
import pl.technicalsite.TemplateModel.TemplateComponentsDto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TemplateServiceImplTest {

    private final String CUT_LINE = "";
    private final String MATCH_LINE = "<xsl:template match=\"root/item\">";
    private final String HEADERS = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">";
    private final String STRUCTURE = "root/item";

    @Mock
    private Template template;
    @InjectMocks
    private TemplateServiceImpl templateService;

    @Test
    void createTemplateSuccess(){

        FieldsBuilder fieldsBuilder = buildFieldsBuilder();
        TemplateComponentsDto templateComponentsDto = buildTemplateComponentsDto();

        when(template.createFile(any(),any())).thenReturn("createdFile");

        String expected = "createdFile";

        assertThat(templateService.createTemplate(templateComponentsDto, fieldsBuilder))
                .isNotNull()
                .isEqualTo(expected);
    }

    @Test
    void createTemplateWithNullFieldsBuilder(){

        FieldsBuilder fieldsBuilder = null;
        TemplateComponentsDto templateComponentsDto = buildTemplateComponentsDto();

        assertThat(templateService.createTemplate(templateComponentsDto, fieldsBuilder))
                .isNull();
    }

    @Test
    void createTemplateWithException(){

        FieldsBuilder fieldsBuilder = buildFieldsBuilder();
        TemplateComponentsDto templateComponentsDto = buildTemplateComponentsDto();

        when(template.createFile(any(), any())).thenThrow(RuntimeException.class);

        String result = templateService.createTemplate(templateComponentsDto, fieldsBuilder);
        assertNull(result);
    }

    private TemplateComponentsDto buildTemplateComponentsDto(){
        return new TemplateComponentsDto.Builder()
                .cutLine(CUT_LINE)
                .matchLine(MATCH_LINE)
                .headers(HEADERS)
                .structure(STRUCTURE)
                .build();
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
