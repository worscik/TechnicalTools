package pl.technicalsite.FileModel.Template;

public class TemplateRegex {

    public static final String structure = "(?:template.match\\=\\\"([A-z| \\/]+))";
    public static final String classicKey = "(?:when test=\\\\\\\"string-length\\((.*)\\)\\\\\\\">\\\\)";
    public static final String keyInNumericLine = "(?:when test\\=\\\\\\\"(.*) (=|>))";
    public static final String valueInNumericLine = "(?: ?(?:=|>).?\\'(.*)')";
    public static final String currencyValue = "(?:translate\\(.*\\, \\'([A-z,#&0-9; ]+)\\')";
    public static final String cutLine = "(?:xsl:template match=\\\\\\\"(.*)\\\\\\\"\\/>)";
    public static final String structureLine = "(?:xsl:template match=\\\\\\\"(.*)\\\\\\\">)";

}
