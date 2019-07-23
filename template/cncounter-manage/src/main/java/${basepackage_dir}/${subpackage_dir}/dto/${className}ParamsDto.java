<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "${className}ParamsDto")
public class ${className}ParamsDto implements Serializable {

    <#list table.columns as column>
    <#if column.columnNameLower != "deleted">
        <#if column.simpleJavaType == "String">
        <#else>
            <#if column.columnNameLower == "id">
            <#else>
            </#if>
        </#if>
    @ApiModelProperty(value = "${column.columnAlias}")
    private ${column.simpleJavaType} ${column.columnNameLower};

    </#if>
    </#list>
}
