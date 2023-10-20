<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="UTF-8" />
	<xsl:template match="/">
		 <html>
            <body>
                <h2>SD apple-template</h2>
                    <xsl:apply-templates/>                    
            </body>
        </html>
	</xsl:template>
	
	<xsl:template match="class/student">
		<div>ID: <xsl:value-of select = "@id"/></div>
        <div style="color:green">Vezeteknev:<xsl:apply-templates select="vezeteknev"/></div>
        <div style="color:brown">Keresztnev: <xsl:apply-templates select="keresztnev"/></div>
        <div style="color:orange">Becenev: <xsl:apply-templates select="becenev"/></div>
        <div style="color:blue">Kor: <xsl:apply-templates select="kor"/></div>
        <div style="color:red">Fizetes: <xsl:apply-templates select="fizetes"/></div>
        <br/>
	</xsl:template>
</xsl:stylesheet>