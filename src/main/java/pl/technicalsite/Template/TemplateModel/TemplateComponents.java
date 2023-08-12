package pl.technicalsite.Template.TemplateModel;

public class TemplateComponents {

    private String structure;
    private String headers;
    private String cutLine;
    private String matchLine;

    public TemplateComponents(String structure, String headers, String cutLine, String matchLine) {
        this.structure = structure;
        this.headers = headers;
        this.cutLine = cutLine;
        this.matchLine = matchLine;
    }

    public String getStructure() {
        return structure;
    }

    public String getHeaders() {
        return headers;
    }

    public String getCutLine() {
        return cutLine;
    }

    public String getMatchLine() {
        return matchLine;
    }

    private TemplateComponents(Builder templateBuilder) {
        this.structure = templateBuilder.structure;
        this.headers = templateBuilder.headers;
        this.cutLine = templateBuilder.cutLine;
        this.matchLine = templateBuilder.matchLine;
    }

    @Override
    public String toString() {
        return "TemplateComponents{" +
                "structure='" + structure + '\'' +
                ", headers='" + headers + '\'' +
                ", cutLine='" + cutLine + '\'' +
                ", matchLine='" + matchLine + '\'' +
                '}';
    }

    public static class Builder {
        private String structure;
        private String headers;
        private String cutLine;
        private String matchLine;

        public Builder structure(String structure) {
            this.structure = structure;
            return this;
        }

        public Builder headers(String headers) {
            this.headers = headers;
            return this;
        }

        public Builder cutLine(String cutLine) {
            this.cutLine = cutLine;
            return this;
        }

        public Builder matchLine(String matchLine) {
            this.matchLine = matchLine;
            return this;
        }

        public TemplateComponents build() {
            return new TemplateComponents(this);
        }

    }


}
