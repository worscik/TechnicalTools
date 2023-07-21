package pl.technicalsite.FileService;

import org.springframework.stereotype.Service;
import pl.technicalsite.FileComponents.CutLine.CutLineService;
import pl.technicalsite.FileComponents.Headers.HeadersService;
import pl.technicalsite.FileComponents.MatchLine.MatchLineService;
import pl.technicalsite.FileComponents.Structure.StructureFile;
import pl.technicalsite.FileComponents.TemplateComponentsBuilder.TemplateComponents;
import pl.technicalsite.FileModel.FileDto;

@Service
public class FileService implements IFileService{

    private final CutLineService cutLineService;
    private final HeadersService headersService;
    private final StructureFile structureFile;
    private final MatchLineService matchLineService;

    public FileService(CutLineService cutLineService, HeadersService headersService, StructureFile structureFile, MatchLineService matchLineService) {
        this.cutLineService = cutLineService;
        this.headersService = headersService;
        this.structureFile = structureFile;
        this.matchLineService = matchLineService;
    }

    @Override
    public String preapreStandardFile(FileDto fileDto) {
        if(!checkStructure(fileDto.getStructure())){
            return "Wrong structure...";
        }
        String structure = fileDto.getStructure();
        TemplateComponents templateComponents = new TemplateComponents.Builder()
                .structure(fileDto.getStructure())
                .headers(headersService.reseolveHeaders(structure))
                .cutLine(cutLineService.resolveCutLine(structure))
                .matchLine(matchLineService.resolveMatchLine(structure))
                .build();

        return templateComponents.toString();
    }

    @Override
    public String buildTemplete() {
        return null;
    }

    private boolean checkStructure(String structure) {
        return structureFile.resolveStructure(structure);
    }

}
