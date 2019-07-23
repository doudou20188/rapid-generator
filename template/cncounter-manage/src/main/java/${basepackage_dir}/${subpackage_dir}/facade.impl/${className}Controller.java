<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.facade.impl;

import com.github.pagehelper.PageInfo;
import com.rantion.csf.core.constant.Add;
import com.rantion.csf.core.constant.Modify;
import com.rantion.csf.rpc.dto.ResponseDto;
import ${basepackage}.${subpackage}.dto.${className}RequestDto;
import ${basepackage}.${subpackage}.dto.${className}ResponseDto;
import ${basepackage}.${subpackage}.dto.${className}ParamsDto;
import ${basepackage}.${subpackage}.model.${className}Model;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${basepackage}.${subpackage}.service.${className}Service;

@Api(value = "${className}")
@RestController
@RequestMapping("/${classNameLower}")
public class ${className}Controller{

    @Autowired
    private ${className}Service ${classNameLower}Service;

	@GetMapping
	public ResponseDto<PageInfo<${className}ResponseDto>> list(
			@ModelAttribute ${className}ParamsDto params,
			@RequestParam(value = "pageNumber", required = false) @ApiParam(value = "pageNumber") Integer pageNumber,
			@RequestParam(value = "pageSize", required = false) @ApiParam(value = "pageSize") Integer pageSize) {
		PageInfo<${className}ResponseDto> ${classNameLower}List = ${classNameLower}Service.listPage(pageNumber, pageSize, params);
		return ResponseDto.succeed(${classNameLower}List);
	}

	@PostMapping
	public ResponseDto add(@RequestBody @Validated(Add.class) ${className}RequestDto requestDto) {
		${classNameLower}Service.add(requestDto);
		return ResponseDto.succeed();
	}

	@PutMapping
	public ResponseDto modify(@RequestBody @Validated(Modify.class) ${className}RequestDto requestDto) {
        ${classNameLower}Service.update(requestDto);
		return ResponseDto.succeed();
	}

	@GetMapping(value = "/{id}")
	public ResponseDto<${className}ResponseDto> getById(@PathVariable(value = "id") @ApiParam(value = "id") Integer id) {
		${className}Model ${classNameLower} = ${classNameLower}Service.getById(id);
		${className}ResponseDto responseDto = new ${className}ResponseDto();
		if (null != ${classNameLower}) {
			BeanUtils.copyProperties(${classNameLower}, responseDto);
		}
		return ResponseDto.succeed(responseDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseDto<${className}ResponseDto> deleteById(@PathVariable(value = "id") @ApiParam(value = "id") Integer id) {
		${classNameLower}Service.deleteById(id);
		return ResponseDto.succeed();
	}
}
