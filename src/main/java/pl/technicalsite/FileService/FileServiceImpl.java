package pl.technicalsite.FileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.technicalsite.FieldsModel.*;
import pl.technicalsite.FileComponents.CutLineService;
import pl.technicalsite.FileComponents.HeadersService;
import pl.technicalsite.FileComponents.MatchLineService;
import pl.technicalsite.TemplateModel.TemplateComponentsDto;

import java.util.Optional;


@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);
    private final CutLineService cutLineService;
    private final HeadersService headersService;
    private final MatchLineService matchLineService;
    private final TemplateServiceImpl templateServiceImpl;
    private final TemplateFieldsMapper templateFieldsMapper;
    private final StandardMappingsType standardMappingsType;

    public FileServiceImpl(CutLineService cutLineService,
                           HeadersService headersService,
                           MatchLineService matchLineService,
                           TemplateServiceImpl templateServiceImpl,
                           TemplateFieldsMapper templateFieldsMapper,
                           StandardMappingsType standardMappingsType) {
        this.cutLineService = cutLineService;
        this.headersService = headersService;
        this.matchLineService = matchLineService;
        this.templateServiceImpl = templateServiceImpl;
        this.templateFieldsMapper = templateFieldsMapper;
        this.standardMappingsType = standardMappingsType;
    }

    @Override
    public FileResponse createFile(FileBasicRequest fileBasicRequest) {
        try {
            boolean isStandardStructure =
                    standardMappingsType.resolveStructure(fileBasicRequest.getStructureFile().toLowerCase());
            TemplateComponentsDto templateComponentsDto = buildComponents(fileBasicRequest, isStandardStructure);
            FieldsBuilder fileFields = templateFieldsMapper.buildFileFields(fileBasicRequest.getFields());
            Optional<String> result = templateServiceImpl.createTemplate(templateComponentsDto, fileFields);
            return result
                    .map(s -> new FileResponse(s,true, ""))
                    .orElse(new FileResponse("", false,"Cannot create a file"));
        } catch (Exception e) {
            logger.error("An error occurred while building the file", e);
            return new FileResponse(null, "An error occurred while building the file.");
        }
    }

    private TemplateComponentsDto buildComponents(FileBasicRequest request, boolean isStandardStructure) {
        logger.debug("Building components for fileDto with structure: {}", request.getStructureFile());
        return new TemplateComponentsDto.Builder()
                .structure(request.getStructureFile())
                .headers(headersService.resolveHeaders(request.getStructureFile()))
                .cutLine(isStandardStructure
                        ? cutLineService.resolveCutLine(request.getStructureFile())
                        : cutLineService.resolveCutLine(request.getCutLine()))
                .matchLine(matchLineService.resolveMatchLine(request.getStructureFile()))
                .build();
    }

}
