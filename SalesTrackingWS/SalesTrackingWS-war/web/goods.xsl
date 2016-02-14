<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <div class='box-header'>
           <h3 class='box-title'>Все товары</h3>
       </div>
       <div class='box-body table-responsive no-padding'>
           <table class='table table-hover' style='text-align: center;'>
               <tr>
                   <th>Название</th>
                   <th>Описание</th>
                   <th>Категория</th>
                   <th>Цена</th>
               </tr>
               <xsl:for-each select="goods/good">
                   <tr>
                        <td>
                            <xsl:value-of select="name" />
                        </td>
                        <td>
                            <xsl:value-of select="description" />
                        </td>
                        <td>
                            <xsl:value-of select="category/name" />
                        </td>
                        <td>
                            <xsl:value-of select="price" />
                        </td>
                   </tr>
               </xsl:for-each>
            </table>
        </div>
    </xsl:template>
</xsl:stylesheet>