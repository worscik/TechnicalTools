package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.technicalsite.FieldsModel.FieldsBuilder;
import pl.technicalsite.TemplateModel.Template;
import pl.technicalsite.TemplateModel.TemplateComponentsDto;

import java.util.Objects;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final Template template;
    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    public TemplateServiceImpl(Template template) {
        this.template = template;
    }


    @Override
    public String createTemplate(TemplateComponentsDto templateComponentsDto, FieldsBuilder fieldsBuilder) {
        if (Objects.nonNull(templateComponentsDto) && Objects.nonNull(fieldsBuilder)) {
            try {
                String file = template.createFile(templateComponentsDto, fieldsBuilder);
                logger.info("File created successfully with structure: {}", templateComponentsDto.getStructure());
                return file;
            } catch (Exception e) {
                logger.error("Error creating file with structure: {}", templateComponentsDto.getStructure(), e);
                return null;
            }
        } else {
            logger.warn("TemplateComponentsDto or FieldsBuilder is null.");
            return null;
        }
    }

}
