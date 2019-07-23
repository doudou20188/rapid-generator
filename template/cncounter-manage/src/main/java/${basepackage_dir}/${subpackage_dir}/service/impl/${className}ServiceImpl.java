<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rantion.csf.core.helper.WebHelper;
import com.rantion.csf.rpc.dto.PageDto;
import ${basepackage}.${subpackage}.mapper.${className}Mapper;
import ${basepackage}.${subpackage}.dto.${className}RequestDto;
import ${basepackage}.${subpackage}.dto.${className}ResponseDto;
import ${basepackage}.${subpackage}.dto.${className}ParamsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ${basepackage}.${subpackage}.service.${className}Service;
import ${basepackage}.${subpackage}.model.${className}Model;
import org.springframework.stereotype.Service;

@Service
public class ${className}ServiceImpl implements ${className}Service {

    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    public PageInfo<${className}ResponseDto> listPage(Integer pageNumber, Integer pageSize, ${className}ParamsDto params) {
        pageNumber = pageNumber == null ? PageDto.DEFAULT_PAGE_NUMBER : pageNumber;
        pageSize = pageSize == null ? PageDto.DEFAULT_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNumber, pageSize);
        List<${className}Model> ${classNameLower}List = ${classNameLower}Mapper.listPage(params);
        PageInfo<${className}Model> ${classNameLower}PageInfo = new PageInfo<>(${classNameLower}List);
        List<${className}ResponseDto> responseDtoList = new ArrayList<>();
        for (${className}Model ${classNameLower} : ${classNameLower}PageInfo.getList()) {
            ${className}ResponseDto responseDto = new ${className}ResponseDto();
            BeanUtils.copyProperties(${classNameLower}, responseDto);
            responseDtoList.add(responseDto);
        }
        PageInfo<${className}ResponseDto> result = new PageInfo<>();
        BeanUtils.copyProperties(${classNameLower}PageInfo, result);
        result.setList(responseDtoList);
        return result;
    }

    @Override
    public int add(${className}RequestDto requestDto) {
        ${className}Model ${classNameLower} = new ${className}Model();
        BeanUtils.copyProperties(requestDto, ${classNameLower});
        ${classNameLower}.setCreateBy(WebHelper.getUserSession().getUserName());
        return ${classNameLower}Mapper.insert(${classNameLower});
    }

    @Override
    public int update(${className}RequestDto requestDto) {
        ${className}Model ${classNameLower} = new ${className}Model();
        BeanUtils.copyProperties(requestDto, ${classNameLower});
        ${classNameLower}.setUpdateBy(WebHelper.getUserSession().getUserName());
        return ${classNameLower}Mapper.updateBySelective(${classNameLower});
    }

    @Override
    public ${className}Model getById(Integer id) {
        return ${classNameLower}Mapper.selectById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return ${classNameLower}Mapper.deleteById(id);
    }

}
