package pl.technicalsite.FileModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileDto extends FileCustomDto {

    @JsonProperty("StructureFile")
    private String structure;
    @JsonProperty("Fields")
    private FieldsDto fieldsDto;

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
