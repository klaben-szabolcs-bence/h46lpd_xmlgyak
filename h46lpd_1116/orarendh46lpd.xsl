<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="UTF-8" />
	<xsl:template match="/">
		<html>
			<head>
				<title>Órarend</title>
			</head>
			<body>
				<table border="5" bordercolor="black">
					<tr bgcolor="green">
						<th>Tipus</th>
						<th>Targy</th>
						<th>Idopont</th>
						<th>Helyszin</th>
						<th>Oktato</th>
						<th>Szak</th>
					</tr>
					<xsl:for-each select="orarend/ora">
						<tr>
							<td>
								<xsl:value-of select="@tipus" />
							</td>
							<td>
								<xsl:value-of select="targy" />
							</td>
							<td>
								<xsl:value-of select="child::idopont" />
							</td>
							<td>
								<xsl:value-of select="helyszin" />
							</td>
							<td>
								<xsl:value-of select="oktato" />
							</td>
							<td>
								<xsl:value-of select="szak" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>