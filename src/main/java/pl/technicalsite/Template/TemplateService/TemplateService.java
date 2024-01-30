package pl.technicalsite.Template.TemplateService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.technicalsite.FileModel.FieldsBuilder;
import pl.technicalsite.FileService.FileServiceImpl;
import pl.technicalsite.Template.TemplateModel.Template;
import pl.technicalsite.Template.TemplateModel.TemplateComponents;

@Service
public class TemplateService {

    public final Template template;
    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    public TemplateService(Template template) {
        this.template = template;
    }

    public String createFile(TemplateComponents templateComponents, FieldsBuilder fieldsBuilder) {
        String file = template.createFile(templateComponents, fieldsBuilder);
        logger.info("File created successfully");
        return file;
    }

}
