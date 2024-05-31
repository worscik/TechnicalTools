package pl.technicalsite.FileModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class FileDto extends FileCustomDto {

    @JsonProperty("StructureFile")
    @NotNull(message = "structure cannot be null or empty")
    private String structure;
    @JsonProperty("Fields")
    @NotNull(message = "fields cannot be empty")
    private FieldsDto fieldsDto;

    public FileDto() {
    }

    public FileDto(String structure, FieldsDto fieldsDto) {
        this.structure = structure;
        this.fieldsDto = fieldsDto;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }


    public FieldsDto getFieldsDto() {
        return fieldsDto;
    }

    public void setFieldsDto(FieldsDto fieldsDto) {
        this.fieldsDto = fieldsDto;
    }

}
