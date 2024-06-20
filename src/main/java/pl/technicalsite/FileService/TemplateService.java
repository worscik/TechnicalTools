package pl.technicalsite.FileService;

import pl.technicalsite.FieldsModel.FieldsBuilder;
import pl.technicalsite.TemplateModel.TemplateComponentsDto;

public interface TemplateService {

    String createTemplate(TemplateComponentsDto templateComponentsDto, FieldsBuilder fieldsBuilder);

}
