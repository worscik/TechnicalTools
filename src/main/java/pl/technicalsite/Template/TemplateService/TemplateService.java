package pl.technicalsite.Template.TemplateService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.technicalsite.FileModel.FieldsBuilder;
import pl.technicalsite.FileService.FileService;
import pl.technicalsite.Template.TemplateModel.Template;
import pl.technicalsite.Template.TemplateModel.TemplateComponents;

@Service
public class TemplateService {

    public final Template template;
    private static final Logger logger = LogManager.getLogger(FileService.class);

    public TemplateService(Template template) {
        this.template = template;
    }

    public String createFile(TemplateComponents templateComponents, FieldsBuilder fieldsBuilder) {
        String file = template.createFile(templateComponents, fieldsBuilder);
        logger.info("File created successfully");
        return file;
    }

    public String createFileWithCutUTM(TemplateComponents templateComponents, FieldsBuilder fieldsBuilder) {
        String file = template.createFileWithCutUTM(templateComponents, fieldsBuilder);
        logger.info("File with cutUTM created successfully");
        return file;
    }

}
