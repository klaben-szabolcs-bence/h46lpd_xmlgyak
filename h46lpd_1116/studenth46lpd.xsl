<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="UTF-8" />
	<xsl:template match="/">
		<html>
			<body>
				<table border="5" bordercolor="black">
					<tr bgcolor="green">
						<th>Vezeteknev</th>
						<th>Keresztnev</th>
						<th>Becenev</th>
						<th>Kor</th>
					</tr>
					<xsl:for-each select="class/student">
						<tr>
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
								<xsl:value-of select="kor" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>