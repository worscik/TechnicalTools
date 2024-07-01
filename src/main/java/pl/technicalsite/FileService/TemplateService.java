package pl.technicalsite.FileService;

import pl.technicalsite.FieldsModel.FieldsBuilder;
import pl.technicalsite.TemplateModel.TemplateComponentsDto;

import java.util.Optional;

public interface TemplateService {

    Optional<String> createTemplate(TemplateComponentsDto templateComponentsDto, FieldsBuilder fieldsBuilder);

}
