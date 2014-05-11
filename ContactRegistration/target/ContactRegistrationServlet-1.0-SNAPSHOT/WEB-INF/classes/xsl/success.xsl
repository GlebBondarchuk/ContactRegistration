<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                Success
            </head>
            <body>
                <h1>Contact Saved Successfully.</h1>
                <form action="/registration" method="post">
                    <input type="hidden" name="action" value="PAGINATION"/>
                    <input type="submit" value="To Contacts Table"/>
                </form>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>