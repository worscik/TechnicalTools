package pl.technicalsite.FieldsModel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class FileBasicRequest extends FileCustomLines {

    @NotNull(message = "structure cannot be null or empty")
    private String structureFile;
    @NotNull(message = "fields cannot be empty")
    @Valid
    private FieldsDto fields;

    public FileBasicRequest() {
    }

    public FileBasicRequest(String structureFile, FieldsDto fields) {
        this.structureFile = structureFile;
        this.fields = fields;
    }

    public String getStructureFile() {
        return structureFile;
    }

    public FieldsDto getFields() {
        return fields;
    }


    @Override
    public String toString() {
        return "FileDto{" +
                "structureFile='" + structureFile + '\'' +
                ", fields=" + fields +
                '}';
    }
}
