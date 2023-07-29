package pl.technicalsite.Template.TemplateService;

import org.springframework.stereotype.Service;
import pl.technicalsite.FileModel.FieldsBuilder;
import pl.technicalsite.Template.TemplateModel.Template;
import pl.technicalsite.Template.TemplateModel.TemplateComponents;

@Service
public class TemplateService {

    public final Template template;

    public TemplateService(Template template) {
        this.template = template;
    }

    public String buildStandardFile(TemplateComponents templateComponents, FieldsBuilder fieldsBuilder) {
        return template.createFile(templateComponents, fieldsBuilder);
    }


}
