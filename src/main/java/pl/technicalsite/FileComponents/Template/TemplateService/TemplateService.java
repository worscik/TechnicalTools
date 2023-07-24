package pl.technicalsite.FileComponents.Template.TemplateService;

import org.springframework.stereotype.Service;
import pl.technicalsite.FileComponents.Template.TemplateModel.Template;
import pl.technicalsite.FileComponents.Template.TemplateModel.TemplateComponents;
import pl.technicalsite.FileModel.FieldsDto;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FileFieldsBuilder;

@Service
public class TemplateService {

    public final Template template;

    public TemplateService(Template template) {
        this.template = template;
    }

    public String buildStandardFile(TemplateComponents templateComponents, FileFieldsBuilder fileFieldsBuilder){

        return  template.createFile(templateComponents, fileFieldsBuilder);
    }




}
