<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="UTF-8" />
	<xsl:template match="/">
		<html>
			<body>
				<table border="5" bordercolor="black">
					<tr bgcolor="green">
						<th>ID</th>
						<th>Vezeteknev</th>
						<th>Keresztnev</th>
						<th>Becenev</th>
						<th>Fizetes</th>
						<th>Fokozat</th>
					</tr>
					<xsl:for-each select="class/student">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td>
								<xsl:value-of select="vezeteknev" />
							</td>
							<td>
								<xsl:value-of select="keresztnev" />
							</td>
							<td>
								<xsl:value-of select="becenev" />
							</td>
							<td>
								<xsl:value-of select="fizetes" />
							</td><xsl:choose>
								<xsl:when test="fizetes &gt; 580000">
									<td>magas</td>
								</xsl:when>
								<xsl:when test="fizetes &lt; 480000">
									<td>alacsony</td>
								</xsl:when>
								<xsl:otherwise>
									<td>kozepes</td>
								</xsl:otherwise>
							</xsl:choose>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>