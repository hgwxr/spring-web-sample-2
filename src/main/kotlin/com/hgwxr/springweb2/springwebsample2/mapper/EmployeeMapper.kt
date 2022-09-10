package com.hgwxr.springweb2.springwebsample2.mapper

import com.hgwxr.springweb2.springwebsample2.entity.Employee
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface EmployeeMapper {
    @Select("SELECT * FROM employee")
    fun findAllData():List<Employee>
}