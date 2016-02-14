<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
       <div class='box-header'>
           <h3 class='box-title'>Все магазины</h3>
       </div>
       <div class='box-body table-responsive no-padding'>
           <table class='table table-hover' style='text-align: center;'>
               <tr>
                   <th>Название</th>
                   <th>Адрес</th>
               </tr>
               <xsl:for-each select="shops/shop">
                   <tr>
                        <td>
                            <xsl:value-of select="name" />
                        </td>
                        <td>
                            <xsl:value-of select="address" />
                        </td>
                   </tr>
               </xsl:for-each>
            </table>
        </div>
    </xsl:template>
</xsl:stylesheet>