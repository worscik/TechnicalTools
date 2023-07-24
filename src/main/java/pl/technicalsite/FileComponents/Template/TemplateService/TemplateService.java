package pl.technicalsite.FileComponents.Template.TemplateService;

import org.springframework.stereotype.Service;
import pl.technicalsite.FileComponents.Template.TemplateModel.Template;
import pl.technicalsite.FileComponents.Template.TemplateModel.TemplateComponents;
import pl.technicalsite.FileModel.FieldsBuilder;

@Service
public class TemplateService {

    public final Template template;

    public TemplateService(Template template) {
        this.template = template;
    }

    public String buildStandardFile(TemplateComponents templateComponents, FieldsBuilder fieldsBuilder){

        return  template.createFile(templateComponents, fieldsBuilder);
    }




}
