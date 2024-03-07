<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:g="http://base.google.com/ns/1.0">
    <xsl:output method="text"/>
    <xsl:strip-space elements="node"/>
    <xsl:strip-space elements="*" />

    <xsl:variable name="newline"><xsl:text>&#x0a;</xsl:text></xsl:variable>
    <xsl:variable name="sep"><xsl:text>&#x7f;</xsl:text></xsl:variable>

    <xsl:template match="rss/channel/title | rss/channel/link | rss/channel/description"/>
    <xsl:template match="rss/channel/item">

        <!-- ustawienie zmiennych -->
        <!--EXTERNAL_ID-->
        <xsl:choose>
            <xsl:when test="string-length(id)">
                <xsl:value-of select="normalize-space(id)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--NAME-->
        <xsl:choose>
            <xsl:when test="string-length(name)">
                <xsl:value-of select="substring(normalize-space(name),0,100)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>noName</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--NEW_PRODUCT-->
        <xsl:choose>
            <xsl:when test="new = 'val1'">
                <xsl:value-of select="1"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="0"/>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--AVAILABLE-->
        <xsl:choose>
            <xsl:when test="ava = 'val2'">
                <xsl:value-of select="1"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="0"/>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--BESTSELLER-->
        <xsl:choose>
            <xsl:when test="best = 'val3'">
                <xsl:value-of select="1"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="0"/>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--BRAND-->
        <xsl:choose>
            <xsl:when test="string-length(brand)">
                <xsl:value-of select="substring(normalize-space(brand),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--CATEGORIES-->
        <xsl:choose>
            <xsl:when test="string-length(cats)">
                <xsl:value-of select="substring(normalize-space(cats),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--CATEGORY_MAIN-->
        <xsl:choose>
            <xsl:when test="string-length(cat)">
                <xsl:value-of select="substring(normalize-space(cat),0,200)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--DESCRIPTION-->
        <xsl:choose>
            <xsl:when test="string-length(desc)">
                <xsl:value-of select="substring(normalize-space(desc),0,1024)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--DETAIL_1-->
        <xsl:choose>
            <xsl:when test="string-length(det1)">
                <xsl:value-of select="substring(normalize-space(det1),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--DETAIL_2-->
        <xsl:choose>
            <xsl:when test="string-length(det2)">
                <xsl:value-of select="substring(normalize-space(det2),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--DETAIL_3-->
        <xsl:choose>
            <xsl:when test="string-length(det3)">
                <xsl:value-of select="substring(normalize-space(det3),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--DETAIL_4-->
        <xsl:choose>
            <xsl:when test="string-length(det4)">
                <xsl:value-of select="substring(normalize-space(det4),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--DETAIL_5-->
        <xsl:choose>
            <xsl:when test="string-length(det5)">
                <xsl:value-of select="substring(normalize-space(det5),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--MANUFACTURER-->
        <xsl:choose>
            <xsl:when test="string-length(man)">
                <xsl:value-of select="substring(normalize-space(man),0,100)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--PRICE-->
        <xsl:choose>
            <xsl:when test="string-length(price)">
                <xsl:value-of select="normalize-space(translate(price, ' pln', ''))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--PRICE_PROMO-->
        <xsl:choose>
            <xsl:when test="string-length(sprice)">
                <xsl:value-of select="normalize-space(translate(sprice, ' pln', ''))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--QUANTITY-->
        <xsl:choose>
            <xsl:when test="string-length(qua)">
                <xsl:value-of select="substring(normalize-space(qua),0,100)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--URL_PRODUCT-->
        <xsl:choose>
            <xsl:when test="string-length(url)">
                <xsl:value-of select="substring(normalize-space(url),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--URL_IMG-->
        <xsl:choose>
            <xsl:when test="string-length(img)">
                <xsl:value-of select="substring(normalize-space(img),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--GENDER-->
        <xsl:choose>
            <xsl:when test="gen = 'val4'">
                <xsl:value-of select="1"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="0"/>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--URL_CATEGORY-->
        <xsl:choose>
            <xsl:when test="string-length(UNDEFINED)">
                <xsl:value-of select="substring(normalize-space(UNDEFINED),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--URL_CATEGORY_MARK-->
        <xsl:choose>
            <xsl:when test="string-length(UNDEFINED)">
                <xsl:value-of select="substring(normalize-space(UNDEFINED),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--POPULARITY-->
        <xsl:choose>
            <xsl:when test="string-length(pop)">
                <xsl:value-of select="substring(normalize-space(pop),0,512)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--SEASON-->
        <xsl:choose>
            <xsl:when test="string-length(sea)">
                <xsl:value-of select="substring(normalize-space(sea),0,40)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--COLOR-->
        <xsl:choose>
            <xsl:when test="string-length(col)">
                <xsl:value-of select="substring(normalize-space(col),0,40)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--ADDITIONAL_IMAGE-->
        <xsl:choose>
            <xsl:when test="string-length(UNDEFINED)">
                <xsl:value-of select="substring(normalize-space(UNDEFINED),0,128)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>\N</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="$sep"/>
        <!--INT_DETAIL1-->
        <xsl:text>\N</xsl:text>
        <xsl:value-of select="$sep"/>
        <!--INT_DETAIL2-->
        <xsl:text>\N</xsl:text>
        <xsl:value-of select="$sep"/>
        <!--DEC_DETAIL1-->
        <xsl:text>\N</xsl:text>
        <xsl:value-of select="$sep"/>
        <!--array-->
        <xsl:text>\N</xsl:text>
        <!-- koniec -->
        <xsl:value-of select="$newline"/>
    </xsl:template>
</xsl:stylesheet>
