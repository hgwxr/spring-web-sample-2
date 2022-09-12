package com.hgwxr.springweb2.springwebsample2.mapper

import com.hgwxr.springweb2.springwebsample2.entity.Department
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface DepartmentMapper {
    @Select("SELECT * FROM department")
    fun findAllData():List<Department>
    fun del(id: Int)
}