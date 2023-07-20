package pl.technicalsite.FileModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileCustomDto {

    @JsonProperty("Custom")
    private boolean isCustom;
    @JsonProperty("CutLine")
    private String cutLine;
    @JsonProperty("MatchLine")
    private String matchLine;

    public FileCustomDto(boolean isCustom, String cutLine, String matchLine) {
        this.isCustom = isCustom;
        this.cutLine = cutLine;
        this.matchLine = matchLine;
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

    public String getMatchLine() {
        return matchLine;
    }

    public void setMatchLine(String matchLine) {
        this.matchLine = matchLine;
    }
}
