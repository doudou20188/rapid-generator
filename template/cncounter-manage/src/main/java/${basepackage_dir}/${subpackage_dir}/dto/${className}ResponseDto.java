<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "${className}ResponseDto")
public class ${className}ResponseDto implements Serializable {

    <#list table.columns as column>
    <#if column.columnNameLower != "deleted">
    @ApiModelProperty(value = "${column.columnAlias}", required = true)
    private ${column.simpleJavaType} ${column.columnNameLower};

    </#if>
    </#list>
}
