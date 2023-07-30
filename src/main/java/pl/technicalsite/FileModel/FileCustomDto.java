package pl.technicalsite.FileModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileCustomDto {

    @JsonProperty("Custom")
    private boolean isCustom;
    @JsonProperty("CutLine")
    private String cutLine;
    @JsonProperty("MatchLine")
    private String customMatchLine;

    public FileCustomDto(boolean isCustom, String cutLine, String customMatchLine) {
        this.isCustom = isCustom;
        this.cutLine = cutLine;
        this.customMatchLine = customMatchLine;
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

    public String getCustomMatchLine() {
        return customMatchLine;
    }

    public void setCustomMatchLine(String customMatchLine) {
        this.customMatchLine = customMatchLine;
    }
}
