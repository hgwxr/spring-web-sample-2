package com.hgwxr.springweb2.springwebsample2.service

import com.hgwxr.springweb2.springwebsample2.db.SampleUser
import com.hgwxr.springweb2.springwebsample2.entity.Department
import com.hgwxr.springweb2.springwebsample2.mapper.DepartmentMapper
import com.hgwxr.springweb2.springwebsample2.mapper.EmployeeMapper
import com.hgwxr.springweb2.springwebsample2.utils.RestResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SampleService {


    @Autowired
    private lateinit var  departmentMapper:DepartmentMapper
    @Autowired
    private lateinit var  employeeMapper:EmployeeMapper

    fun findAllDepartment(): List<Department> {
        return departmentMapper.findAllData();
    }

    fun save(sampleUser: SampleUser) {

    }

    fun del(id: Int) {

        departmentMapper.del(id)
    }
}