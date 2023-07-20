package pl.technicalsite.FileModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileDto extends FileCustomDto{

    @JsonProperty("StructureFile")
    private String structure;
    @JsonProperty("HeadersFile")
    private String headers;

    public FileDto(String structure, String headers) {
        super();
        this.structure = structure;
        this.headers = headers;
    }

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

    @Override
    public String toString() {
        return "FileDto{" +
                "structure='" + structure + '\'' +
                ", headers='" + headers + '\'' +
                '}';
    }
}
