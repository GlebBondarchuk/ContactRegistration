<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>
                    Registration!
                </title>
            </head>
            <body>
                <h1>
                    Personal Info Registration
                </h1>

                <form action="/registration" method="post">
                    <input type="hidden" name="formId" value="{//current/id}"/>

                    <div>
                        <label for="firstName">
                            First Name:
                        </label>
                        <xsl:choose>
                            <xsl:when test="//current/firstName">
                                <label>
                                    <xsl:value-of select="//current/firstName"/>
                                    <input type="hidden" name="firstName" value="{//current/firstName}"/>
                                </label>
                            </xsl:when>
                            <xsl:otherwise>
                                <input type="text" size="20" name="firstName"/>
                                <input type="hidden" name="action" value="REGISTRATION"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </div>
                    <br/>

                    <div>
                        <label for="lastName">
                            Last Name:
                        </label>
                        <xsl:choose>
                            <xsl:when test="//current/lastName">
                                <label>
                                    <xsl:value-of select="//current/lastName"/>
                                    <input type="hidden" name="lastName" value="{//current/lastName}"/>
                                </label>
                            </xsl:when>
                            <xsl:otherwise>
                                <input type="text" size="20" name="lastName"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </div>
                    <br/>

                    <xsl:if test="//current/lastName">
                        <div>
                            <label for="companyName">
                                Company Name:
                            </label>
                            <xsl:choose>
                                <xsl:when test="//current/companyName">
                                    <label>
                                        <xsl:value-of select="//current/companyName"/>
                                        <input type="hidden" name="companyName" value="{//current/companyName}"/>
                                    </label>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="text" size="20" name="companyName"/>
                                    <input type="hidden" name="action" value="REGISTRATION"/>
                                </xsl:otherwise>
                            </xsl:choose>
                        </div>
                        <br/>
                    </xsl:if>

                    <xsl:if test="//current/companyName">
                        <div>
                            <label for="hobby">
                                Hobby:
                            </label>
                            <xsl:choose>
                                <xsl:when test="//current/hobby">
                                    <label>
                                        <xsl:value-of select="//current/hobby"/>
                                        <input type="hidden" name="hobby" value="{//current/hobby}"/>
                                    </label>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="text" size="20" name="hobby"/>
                                    <input type="hidden" name="action" value="SAVE_CONTACT"/>
                                </xsl:otherwise>
                            </xsl:choose>
                        </div>
                        <br/>
                    </xsl:if>

                    <input type="submit" value="Next"/>
                </form>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
