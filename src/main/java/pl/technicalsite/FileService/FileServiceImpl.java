package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.technicalsite.FileComponents.CutLineService;
import pl.technicalsite.FileComponents.HeadersService;
import pl.technicalsite.FileComponents.MatchLineService;
import pl.technicalsite.FileModel.*;
import pl.technicalsite.FileModel.Template.TemplateComponentsDto;

import static pl.technicalsite.FileModel.MappingsType.listOfAvailableStructure;


@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);
    private final CutLineService cutLineService;
    private final HeadersService headersService;
    private final MatchLineService matchLineService;
    private final TemplateService templateService;
    private final TemplateFieldsMapper templateFieldsMapper;
    private final MappingsType mappingsType;

    public FileServiceImpl(CutLineService cutLineService,
                           HeadersService headersService,
                           MatchLineService matchLineService,
                           TemplateService templateService,
                           TemplateFieldsMapper templateFieldsMapper,
                           MappingsType mappingsType) {
        this.cutLineService = cutLineService;
        this.headersService = headersService;
        this.matchLineService = matchLineService;
        this.templateService = templateService;
        this.templateFieldsMapper = templateFieldsMapper;
        this.mappingsType = mappingsType;
    }

    @Override
    public FileResponse createFile(FileDto fileDto) {
        boolean isStandard = mappingsType.resolveStructure(fileDto.getStructure().toLowerCase());
        try {
            TemplateComponentsDto templateComponentsDto = isStandard
                    ? buildStandardComponentsTemplate(fileDto)
                    : buildCustomComponentsTemplate(fileDto);
            FieldsBuilder fileFields = templateFieldsMapper.buildFileFields(fileDto.getFieldsDto());
            String file = templateService.createTemplate(templateComponentsDto, fileFields);
            return new FileResponse(file, "");
        } catch (Exception e) {
            logger.error("An error occurred while building the file", e);
            return new FileResponse(null, "An error occurred while building the file.");
        }
    }

    private TemplateComponentsDto buildStandardComponentsTemplate(FileDto fileDto) {
        return new TemplateComponentsDto.Builder()
                .structure(fileDto.getStructure())
                .headers(headersService.resolveHeaders(fileDto.getStructure()))
                .cutLine(cutLineService.resolveCutLine(fileDto.getStructure()))
                .matchLine(matchLineService.resolveMatchLine(fileDto.getStructure()))
                .build();
    }

    private TemplateComponentsDto buildCustomComponentsTemplate(FileDto fileDto) {
        return new TemplateComponentsDto.Builder()
                .structure(fileDto.getStructure())
                .headers(headersService.resolveHeaders(fileDto.getStructure()))
                .cutLine(cutLineService.resolveCutLine(fileDto.getCutLine()))
                .matchLine(matchLineService.resolveMatchLine(fileDto.getStructure()))
                .build();
    }


}