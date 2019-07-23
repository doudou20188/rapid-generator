<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.mapper.mysql;

import java.util.List;

import ${basepackage}.${subpackage}.model.${className}Model;
import ${basepackage}.${subpackage}.dto.${className}ParamsDto;

public interface ${className}Mapper {

    List<${className}Model> listPage(${className}ParamsDto params);

    int insert(${className}Model ${classNameLower});

    int updateBySelective(${className}Model ${classNameLower});

    ${className}Model selectById(Integer id);

    int deleteById(Integer id);

}