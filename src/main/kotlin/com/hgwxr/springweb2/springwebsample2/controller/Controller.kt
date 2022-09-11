package com.hgwxr.springweb2.springwebsample2.controller

import com.hgwxr.springweb2.springwebsample2.service.SampleService
import com.hgwxr.springweb2.springwebsample2.utils.RestResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @Autowired
    private lateinit var _sampleService: SampleService
    @RequestMapping("/helloworld")
    fun  helloWorld():String{
        return "hello world"
    }

    @RequestMapping("/all-department")
    fun  findAllDepartment(): RestResponse {
        val list = _sampleService.findAllDepartment()
        return RestResponse.buildSuccess(list)
    }

}