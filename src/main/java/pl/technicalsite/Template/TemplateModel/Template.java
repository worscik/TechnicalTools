package pl.technicalsite.Template.TemplateModel;

import org.springframework.stereotype.Component;
import pl.technicalsite.FileModel.FieldsBuilder;

@Component
public class Template {

    public static final String NEWLINE = "\n";

    public String createFile(TemplateComponents templateComponents, FieldsBuilder fileField) {

        String sb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + NEWLINE
                + templateComponents.getHeaders() + NEWLINE +
                "    <xsl:output method=\"text\"/>" + NEWLINE +
                "    <xsl:strip-space elements=\"node\"/>" + NEWLINE +
                "    <xsl:strip-space elements=\"*\" />" + NEWLINE +
                NEWLINE +
                "    <xsl:variable name=\"newline\"><xsl:text>&#x0a;</xsl:text></xsl:variable>" + NEWLINE +
                "    <xsl:variable name=\"sep\"><xsl:text>&#x7f;</xsl:text></xsl:variable>" + NEWLINE +
                NEWLINE +
                templateComponents.getCutLine() + NEWLINE +
                templateComponents.getMatchLine() + NEWLINE +
                NEWLINE +
                "        <!-- ustawienie zmiennych -->" + NEWLINE +
                "        <!--EXTERNAL_ID-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getId() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"normalize-space(" + fileField.getId() + ")\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--NAME-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getName() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getName() + "),0,100)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>noName</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--NEW_PRODUCT-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"" + fileField.getNewProductKey() + " " + "= '" + fileField.getNewProductValue() + "'\">" + NEWLINE +
                "                <xsl:value-of select=\"1\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:value-of select=\"0\"/>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--AVAILABLE-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"" + fileField.getAvailableKey() + " " + "= '" + fileField.getAvailableValue() + "'\">" + NEWLINE +
                "                <xsl:value-of select=\"1\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:value-of select=\"0\"/>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--BESTSELLER-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"" + fileField.getBestsellerKey() + " " + "= '" + fileField.getBestsellerValue() + "'\">" + NEWLINE +
                "                <xsl:value-of select=\"1\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:value-of select=\"0\"/>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--BRAND-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getBrand() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getBrand() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--CATEGORIES-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getCategories() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getCategories() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--CATEGORY_MAIN-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getCategoryMain() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getCategoryMain() + "),0,200)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DESCRIPTION-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDescription() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDescription() + "),0,1024)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_1-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail1() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail1() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_2-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail2() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail2() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_3-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail3() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail3() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_4-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail4() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail4() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_5-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail5() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail5() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--MANUFACTURER-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getManufacturer() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getManufacturer() + "),0,100)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--PRICE-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getPrice() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"normalize-space(translate(" + fileField.getPrice() + ", \'" + fileField.getCurrency() + "\', \'\'))\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--PRICE_PROMO-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getPricePromo() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"normalize-space(translate(" + fileField.getPricePromo() + ", \'" + fileField.getCurrency() + "\', \'\'))\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                //TODO ZMIENIC NA LICZBOWE
                "        <!--QUANTITY-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getQuantity() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getQuantity() + "),0,100)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--URL_PRODUCT-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getUrlProduct() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getUrlProduct() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--URL_IMG-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getUrlImg() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getUrlImg() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--GENDER-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"" + fileField.getNewProductKey() + " " + "= '" + fileField.getGenderValue() + "'\">" + NEWLINE +
                "                <xsl:value-of select=\"1\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:value-of select=\"0\"/>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--URL_CATEGORY-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getUrlCategory() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getUrlCategory() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--URL_CATEGORY_MARK-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getUrlCategory() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getUrlCategory() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--POPULARITY-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getPopularity() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getPopularity() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--SEASON-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getSeason() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getSeason() + "),0,40)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--COLOR-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getColor() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getColor() + "),0,40)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--ADDITIONAL_IMAGE-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getAddidtionalImage() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getAddidtionalImage() + "),0,128)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--INT_DETAIL1-->" + NEWLINE +
                "        <xsl:text>\\N</xsl:text>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--INT_DETAIL2-->" + NEWLINE +
                "        <xsl:text>\\N</xsl:text>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DEC_DETAIL1-->" + NEWLINE +
                "        <xsl:text>\\N</xsl:text>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--array-->" + NEWLINE +
                "        <xsl:text>\\N</xsl:text>" + NEWLINE +
                "        <!-- koniec -->" + NEWLINE +
                "        <xsl:value-of select=\"$newline\"/>" + NEWLINE +
                "    </xsl:template>" + NEWLINE +
                "</xsl:stylesheet>" + NEWLINE;
        return sb;
    }

    public String createFileWithCutUTM(TemplateComponents templateComponents, FieldsBuilder fileField) {

        String sb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + NEWLINE
                + templateComponents.getHeaders() + NEWLINE +
                "    <xsl:output method=\"text\"/>" + NEWLINE +
                "    <xsl:strip-space elements=\"node\"/>" + NEWLINE +
                "    <xsl:strip-space elements=\"*\" />" + NEWLINE +
                NEWLINE +
                "    <xsl:variable name=\"newline\"><xsl:text>&#x0a;</xsl:text></xsl:variable>" + NEWLINE +
                "    <xsl:variable name=\"sep\"><xsl:text>&#x7f;</xsl:text></xsl:variable>" + NEWLINE +
                NEWLINE +
                templateComponents.getCutLine() + NEWLINE +
                templateComponents.getMatchLine() + NEWLINE +
                NEWLINE +
                "        <!-- ustawienie zmiennych -->" + NEWLINE +
                "        <!--EXTERNAL_ID-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getId() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"normalize-space(" + fileField.getId() + ")\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--NAME-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getName() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getName() + "),0,100)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>noName</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--NEW_PRODUCT-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"" + fileField.getNewProductKey() + " " + "= '" + fileField.getNewProductValue() + "'\">" + NEWLINE +
                "                <xsl:value-of select=\"1\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:value-of select=\"0\"/>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--AVAILABLE-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"" + fileField.getAvailableKey() + " " + "= '" + fileField.getAvailableValue() + "'\">" + NEWLINE +
                "                <xsl:value-of select=\"1\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:value-of select=\"0\"/>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--BESTSELLER-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"" + fileField.getBestsellerKey() + " " + "= '" + fileField.getBestsellerValue() + "'\">" + NEWLINE +
                "                <xsl:value-of select=\"1\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:value-of select=\"0\"/>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--BRAND-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getBrand() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getBrand() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--CATEGORIES-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getCategories() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getCategories() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--CATEGORY_MAIN-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getCategoryMain() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getCategoryMain() + "),0,200)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DESCRIPTION-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDescription() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDescription() + "),0,1024)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_1-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail1() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail1() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_2-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail2() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail2() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_3-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail3() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail3() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_4-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail4() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail4() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DETAIL_5-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getDetail5() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getDetail5() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--MANUFACTURER-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getManufacturer() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getManufacturer() + "),0,100)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--PRICE-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getPrice() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"normalize-space(translate(" + fileField.getPrice() + ", \'" + fileField.getCurrency() + "\', \'\'))\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--PRICE_PROMO-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getPricePromo() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"normalize-space(translate(" + fileField.getPricePromo() + ", \'" + fileField.getCurrency() + "\', \'\'))\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--QUANTITY-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getQuantity() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getQuantity() + "),0,100)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--URL_PRODUCT-->" + NEWLINE +
                "        <xsl:when test=\"contains(" + fileField.getUrlProduct() +",\'?\')\">" + NEWLINE +
                "           <xsl:value-of select=\"substing(" + fileField.getUrlProduct() + ",\'?\'),0,512)\">" + NEWLINE +
                "        </xsl:when>" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getUrlProduct() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getUrlProduct() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--URL_IMG-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getUrlImg() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getUrlImg() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--GENDER-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"" + fileField.getNewProductKey() + " " + "= '" + fileField.getGenderValue() + "'\">" + NEWLINE +
                "                <xsl:value-of select=\"1\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:value-of select=\"0\"/>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--URL_CATEGORY-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getUrlCategory() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getUrlCategory() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--URL_CATEGORY_MARK-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getUrlCategory() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getUrlCategory() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--POPULARITY-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getPopularity() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getPopularity() + "),0,512)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--SEASON-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getSeason() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getSeason() + "),0,40)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--COLOR-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getColor() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getColor() + "),0,40)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--ADDITIONAL_IMAGE-->" + NEWLINE +
                "        <xsl:choose>" + NEWLINE +
                "            <xsl:when test=\"string-length(" + fileField.getAddidtionalImage() + ")\">" + NEWLINE +
                "                <xsl:value-of select=\"substring(normalize-space(" + fileField.getAddidtionalImage() + "),0,128)\"/>" + NEWLINE +
                "            </xsl:when>" + NEWLINE +
                "            <xsl:otherwise>" + NEWLINE +
                "                <xsl:text>\\N</xsl:text>" + NEWLINE +
                "            </xsl:otherwise>" + NEWLINE +
                "        </xsl:choose>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--INT_DETAIL1-->" + NEWLINE +
                "        <xsl:text>\\N</xsl:text>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--INT_DETAIL2-->" + NEWLINE +
                "        <xsl:text>\\N</xsl:text>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--DEC_DETAIL1-->" + NEWLINE +
                "        <xsl:text>\\N</xsl:text>" + NEWLINE +
                "        <xsl:value-of select=\"$sep\"/>" + NEWLINE +
                "        <!--array-->" + NEWLINE +
                "        <xsl:text>\\N</xsl:text>" + NEWLINE +
                "        <!-- koniec -->" + NEWLINE +
                "        <xsl:value-of select=\"$newline\"/>" + NEWLINE +
                "    </xsl:template>" + NEWLINE +
                "</xsl:stylesheet>" + NEWLINE;
        return sb;
    }

}
