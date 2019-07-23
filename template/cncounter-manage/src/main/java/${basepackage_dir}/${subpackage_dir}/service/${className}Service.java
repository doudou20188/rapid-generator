<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.service;


import com.github.pagehelper.PageInfo;
import ${basepackage}.${subpackage}.dto.${className}RequestDto;
import ${basepackage}.${subpackage}.dto.${className}ResponseDto;
import ${basepackage}.${subpackage}.dto.${className}ParamsDto;
import ${basepackage}.${subpackage}.model.${className}Model;

public interface ${className}Service {

	PageInfo<${className}ResponseDto> listPage(Integer pageNumber, Integer pageSize,${className}ParamsDto params);

	int add(${className}RequestDto requestDto);

	int update(${className}RequestDto requestDto);

	${className}Model getById(Integer id);

	int deleteById(Integer id);
}
