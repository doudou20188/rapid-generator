<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.model;

import lombok.Data;

import java.util.Date;

/**
 * ${table.tableAlias}
 * @version 1.0
 * @author
 */
@Data
public class ${className}Model {

	<#list table.columns as column>
	// ${column.columnAlias}
	private ${column.simpleJavaType} ${column.columnNameLower};
	</#list>
}
