<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="UTF-8" />
    <xsl:template match="/">
        <html>
            <body>
                <h2>Miskolci lakosok autoinak rendszamai</h2>
                <ol>
                    <xsl:for-each select = "autok/auto">
                        <xsl:choose>
                            <xsl:when test = "tulaj/varos = 'Miskolc'">
                                <li>
                                    <xsl:value-of select = "@rsz"/>
                                </li>
                            </xsl:when>
                    </xsl:choose>
                    </xsl:for-each>
                </ol>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>