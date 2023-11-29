package pl.technicalsite.FileModel;

public class XmlFileTest {

    public static String XMLFILE = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\"\n" +
            "\t\txmlns:g=\"http://base.google.com/ns/1.0\">\n" +
            "    <xsl:output method=\"text\"/>\n" +
            "    <xsl:strip-space elements=\"node\"/>\n" +
            "    <xsl:strip-space elements=\"*\" />\n" +
            "\n" +
            "    <xsl:variable name=\"newline\"><xsl:text>&#x0a;</xsl:text></xsl:variable>\n" +
            "    <xsl:variable name=\"sep\"><xsl:text>&#x7f;</xsl:text></xsl:variable>\n" +
            "\n" +
            "<xsl:template match=\"rss/channel/title | rss/channel/link | rss/channel/description\"/>\n" +
            "<xsl:template match=\"rss/channel/item\">\n" +
            "\n" +
            "        <!-- ustawienie zmiennych -->\n" +
            "        <!--EXTERNAL_ID-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(id)\">\n" +
            "                <xsl:value-of select=\"normalize-space(id)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--NAME-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(name)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(name),0,100)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>noName</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--NEW_PRODUCT-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"product = 'productValue'\">\n" +
            "                <xsl:value-of select=\"1\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:value-of select=\"0\"/>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--AVAILABLE-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"available = 'availableValue'\">\n" +
            "                <xsl:value-of select=\"1\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:value-of select=\"0\"/>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--BESTSELLER-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"bestseller = 'bestsellerValue'\">\n" +
            "                <xsl:value-of select=\"1\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:value-of select=\"0\"/>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--BRAND-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(Brand)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(Brand),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--CATEGORIES-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(categories)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(categories),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--CATEGORY_MAIN-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(categoryMain)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(categoryMain),0,200)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--DESCRIPTION-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(description)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(description),0,1024)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--DETAIL_1-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(detal1)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(detal1),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--DETAIL_2-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(detal2)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(detal2),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--DETAIL_3-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(detal3)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(detal3),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--DETAIL_4-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(detal4)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(detal4),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--DETAIL_5-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(detal5)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(detal5),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--MANUFACTURER-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(manu)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(manu),0,100)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--PRICE-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(price)\">\n" +
            "                <xsl:value-of select=\"normalize-space(translate(price, 'curr', ''))\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--PRICE_PROMO-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(promo)\">\n" +
            "                <xsl:value-of select=\"normalize-space(translate(promo, 'curr', ''))\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--QUANTITY-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(quan)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(quan),0,100)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--URL_PRODUCT-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(urlProd)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(urlProd),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--URL_IMG-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(UrlImg)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(UrlImg),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--GENDER-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"genderKey = 'genderVal'\">\n" +
            "                <xsl:value-of select=\"1\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:value-of select=\"0\"/>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--URL_CATEGORY-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(UNDEFINED)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(UNDEFINED),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--URL_CATEGORY_MARK-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(UNDEFINED)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(UNDEFINED),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--POPULARITY-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(pop)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(pop),0,512)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--SEASON-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(ses)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(ses),0,40)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--COLOR-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(colo)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(colo),0,40)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--ADDITIONAL_IMAGE-->\n" +
            "        <xsl:choose>\n" +
            "            <xsl:when test=\"string-length(UNDEFINED)\">\n" +
            "                <xsl:value-of select=\"substring(normalize-space(UNDEFINED),0,128)\"/>\n" +
            "            </xsl:when>\n" +
            "            <xsl:otherwise>\n" +
            "                <xsl:text>\\N</xsl:text>\n" +
            "            </xsl:otherwise>\n" +
            "        </xsl:choose>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--INT_DETAIL1-->\n" +
            "        <xsl:text>\\N</xsl:text>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--INT_DETAIL2-->\n" +
            "        <xsl:text>\\N</xsl:text>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--DEC_DETAIL1-->\n" +
            "        <xsl:text>\\N</xsl:text>\n" +
            "        <xsl:value-of select=\"$sep\"/>\n" +
            "        <!--array-->\n" +
            "        <xsl:text>\\N</xsl:text>\n" +
            "        <!-- koniec -->\n" +
            "        <xsl:value-of select=\"$newline\"/>\n" +
            "    </xsl:template>\n" +
            "</xsl:stylesheet>\n";


}
