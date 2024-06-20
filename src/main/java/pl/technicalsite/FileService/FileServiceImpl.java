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
    public FileResponse createFile(FileDto fileDto) {
        try {
            boolean isStandardStructure =
                    standardMappingsType.resolveStructure(fileDto.getStructureFile().toLowerCase());
            TemplateComponentsDto templateComponentsDto = buildComponents(fileDto, isStandardStructure);
            FieldsBuilder fileFields = templateFieldsMapper.buildFileFields(fileDto.getFields());
            Optional<String> file =
                    Optional.ofNullable(templateServiceImpl.createTemplate(templateComponentsDto, fileFields));
            return file
                    .map(s -> new FileResponse(s, ""))
                    .orElseGet(() -> new FileResponse("", "Cannot create a file"));
        } catch (Exception e) {
            logger.error("An error occurred while building the file", e);
            return new FileResponse(null, "An error occurred while building the file.");
        }
    }

    private TemplateComponentsDto buildComponents(FileDto fileDto, boolean isStandardStructure) {
        logger.debug("Building components for fileDto with structure: {}", fileDto.getStructureFile());
        return new TemplateComponentsDto.Builder()
                .structure(fileDto.getStructureFile())
                .headers(headersService.resolveHeaders(fileDto.getStructureFile()))
                .cutLine(isStandardStructure
                        ? cutLineService.resolveCutLine(fileDto.getStructureFile())
                        : cutLineService.resolveCutLine(fileDto.getCutLine()))
                .matchLine(matchLineService.resolveMatchLine(fileDto.getStructureFile()))
                .build();
    }

}
