package pl.technicalsite.FileService;

import org.springframework.stereotype.Service;
import pl.technicalsite.FileComponents.CutLine.CutLine;
import pl.technicalsite.FileComponents.Headers.Headers;
import pl.technicalsite.FileComponents.Structure.StructureFile;

@Service
public class FileService implements IFileService{

    private final CutLine cutLine;
    private final Headers headers;
    private final StructureFile structureFile;

    public FileService(CutLine cutLine, Headers headers, StructureFile structureFile) {
        this.cutLine = cutLine;
        this.headers = headers;
        this.structureFile = structureFile;
    }

    @Override
    public boolean checkStructure(String structure) {
        return structureFile.resolveStructure(structure);
    }

    @Override
    public String perpareFile() {
        return null;
    }

    @Override
    public String buildTemplete() {
        return null;
    }
}
