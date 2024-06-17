package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.technicalsite.FileModel.FieldsBuilder;
import pl.technicalsite.FileModel.Template.Template;
import pl.technicalsite.FileModel.Template.TemplateComponentsDto;

@Service
public class TemplateService {

    public final Template template;
    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    public TemplateService(Template template) {
        this.template = template;
    }

    public String createTemplate(TemplateComponentsDto templateComponentsDto, FieldsBuilder fieldsBuilder) {
        String file = template.createFile(templateComponentsDto, fieldsBuilder);
        logger.info("File created successfully");
        return file;
    }

}
