package pl.technicalsite.FileModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileCustomDto {
    @JsonProperty("CutLine")
    private String cutLine;
    @JsonProperty("MatchLine")
    private String matchLine;

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
