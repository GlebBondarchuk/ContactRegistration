<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                Saved Contacts
            </head>
            <body>
                <table>
                    <thead>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Company Name</th>
                        <th>Hobby</th>
                    </thead>
                    <tbody>
                        <xsl:for-each select="//contacts/com.bsu.registration.model.Contact">
                            <tr>
                                <td>
                                    <xsl:value-of select="firstName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="lastName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="companyName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="hobby"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
                <form action="/registration" method="post">
                    <div>
                        <span>
                            <input type="submit" value="LEFT" name="direction"/>
                        </span>
                        <span>
                            <input type="submit" value="RIGHT" name="direction"/>
                        </span>
                    </div>
                    <input type="hidden" name="position" value="{//position}"/>
                    <input type="hidden" name="action" value="PAGINATION"/>
                </form>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>