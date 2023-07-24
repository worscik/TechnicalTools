package pl.technicalsite.FileService;

import org.springframework.stereotype.Service;
import pl.technicalsite.FileComponents.CutLine.CutLineService;
import pl.technicalsite.FileComponents.Headers.HeadersService;
import pl.technicalsite.FileComponents.MatchLine.MatchLineService;
import pl.technicalsite.FileComponents.Structure.StructureFile;
import pl.technicalsite.FileComponents.Template.TemplateModel.TemplateComponents;
import pl.technicalsite.FileComponents.Template.TemplateService.TemplateService;
import pl.technicalsite.FileModel.FieldsDto;
import pl.technicalsite.FileModel.FileDto;
import pl.technicalsite.FileModel.FieldsBuilder;

@Service
public class FileService implements IFileService{

    private final CutLineService cutLineService;
    private final HeadersService headersService;
    private final StructureFile structureFile;
    private final MatchLineService matchLineService;
    private final TemplateService templateService;

    public FileService(CutLineService cutLineService, HeadersService headersService,
                       StructureFile structureFile, MatchLineService matchLineService,
                       TemplateService templateService) {
        this.cutLineService = cutLineService;
        this.headersService = headersService;
        this.structureFile = structureFile;
        this.matchLineService = matchLineService;
        this.templateService = templateService;
    }

    @Override
    public String preapreStandardFile(FileDto fileDto) {
        if(!checkStructure(fileDto.getStructure())){
            return "Structure is not correct";
        }
        String structure = fileDto.getStructure();
        TemplateComponents templateComponents = buildComponentsTemplate(structure);
//        FileFieldsBuilder fileFieldsBuilder = biuldFileFields(fileDto.getFieldsDto());
        FieldsBuilder fileFields = biuldFileFields(fileDto.getFieldsDto());
        return templateService.buildStandardFile(templateComponents, fileFields);
    }

    @Override
    public String buildTemplete() {
        return null;
    }

    private boolean checkStructure(String structure) {
        return structureFile.resolveStructure(structure);
    }

    private TemplateComponents buildComponentsTemplate(String structure){
        return new TemplateComponents.Builder()
                .structure(structure)
                .headers(headersService.reseolveHeaders(structure))
                .cutLine(cutLineService.resolveCutLine(structure))
                .matchLine(matchLineService.resolveMatchLine(structure))
                .build();
    }

    private FieldsBuilder biuldFileFields(FieldsDto fieldsDto){
        return new FieldsBuilder.Builder()
                .id(fieldsDto.getId())
                .name(fieldsDto.getName())
                .newProductValue(fieldsDto.getNewProductValue())
                .newProductValue(fieldsDto.getNewProductValue())
                .build();
    }

}
