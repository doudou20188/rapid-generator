<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.dto;

import com.rantion.csf.core.constant.Add;
import com.rantion.csf.core.constant.Modify;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "${className}RequestDto")
public class ${className}RequestDto implements Serializable {

    <#list table.columns as column>
    <#if column.columnNameLower != "deleted" && column.columnNameLower != "createBy" && column.columnNameLower != "createTime" && column.columnNameLower != "updateBy" && column.columnNameLower != "updateTime">
        <#if column.simpleJavaType == "String">
    @NotBlank(groups = {Add.class, Modify.class},message = "${column.columnAlias}不能为空")
        <#else>
            <#if column.columnNameLower == "id">
    @NotNull(groups = {Modify.class},message = "${column.columnAlias}不能为空")
            <#else>
    @NotNull(groups = {Add.class, Modify.class},message = "${column.columnAlias}不能为空")
            </#if>
        </#if>
    @ApiModelProperty(value = "${column.columnAlias}", required = true)
    private ${column.simpleJavaType} ${column.columnNameLower};

    </#if>
    </#list>
}
