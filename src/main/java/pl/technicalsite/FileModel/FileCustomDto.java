package pl.technicalsite.FileModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileCustomDto {

    @JsonProperty("Custom")
    private boolean isCustom;
    @JsonProperty("CutLine")
    private String cutLine;

    public FileCustomDto(boolean isCustom, String cutLine) {
        this.isCustom = isCustom;
        this.cutLine = cutLine;
    }

    public FileCustomDto() {
    }

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean custom) {
        isCustom = custom;
    }

    public String getCutLine() {
        return cutLine;
    }

    public void setCutLine(String cutLine) {
        this.cutLine = cutLine;
    }

}
