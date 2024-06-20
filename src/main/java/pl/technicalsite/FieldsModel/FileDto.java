package pl.technicalsite.FieldsModel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class FileDto extends FileCustomDto {

    @NotNull(message = "structure cannot be null or empty")
    private String structureFile;
    @NotNull(message = "fields cannot be empty")
    @Valid
    private FieldsDto fields;

    public FileDto() {
    }

    public FileDto(String structureFile, FieldsDto fields) {
        this.structureFile = structureFile;
        this.fields = fields;
    }

    public String getStructureFile() {
        return structureFile;
    }

    public void setStructureFile(String structureFile) {
        this.structureFile = structureFile;
    }


    public FieldsDto getFields() {
        return fields;
    }

    public void setFields(FieldsDto fields) {
        this.fields = fields;
    }

}
