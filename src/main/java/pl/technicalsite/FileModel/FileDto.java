package pl.technicalsite.FileModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileDto extends FileCustomDto{

    @JsonProperty("StructureFile")
    private String structure;
    @JsonProperty("HeadersFile")
    private String headers;
    @JsonProperty("Fields")
    private FieldsDto fieldsDto;

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public FieldsDto getFieldsDto() {
        return fieldsDto;
    }

    public void setFieldsDto(FieldsDto fieldsDto) {
        this.fieldsDto = fieldsDto;
    }

    @Override
    public String toString() {
        return "FileDto{" +
                "structure='" + structure + '\'' +
                ", headers='" + headers + '\'' +
                ", fieldsDto=" + fieldsDto +
                '}';
    }
}
