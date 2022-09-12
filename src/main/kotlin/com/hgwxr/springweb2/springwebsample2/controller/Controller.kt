package com.hgwxr.springweb2.springwebsample2.controller

import com.hgwxr.springweb2.springwebsample2.db.SampleUser
import com.hgwxr.springweb2.springwebsample2.service.SampleService
import com.hgwxr.springweb2.springwebsample2.service.SampleUserService
import com.hgwxr.springweb2.springwebsample2.utils.RestResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class Controller {

    @Autowired
    private lateinit var _sampleService: SampleService
    @Autowired
    private lateinit var _sampleUserService: SampleUserService
    @RequestMapping("/helloworld")
    fun  helloWorld():String{
        return "hello world"
    }

    @RequestMapping("/all-department")
    fun  findAllDepartment(): RestResponse {
        val list = _sampleService.findAllDepartment()
        return RestResponse.buildSuccess(list)
    }
    @RequestMapping("/all-sample-user")
    fun  findAllSampleUser(): RestResponse {
        val list = _sampleUserService.getAll()
        return RestResponse.buildSuccess(list)
    }
    @DeleteMapping("/del-sample-user/{user_id}")
    fun  delSampleUser(@PathVariable("user_id") id:Int): RestResponse {
        val list = _sampleUserService.delById(id)
        return RestResponse.buildSuccess(list)
    }
    @PostMapping("/save-sample-user")
    fun  saveSampleUser(@RequestBody sampleUser:  SampleUser): RestResponse {
        val list = _sampleUserService.save(sampleUser)
        return RestResponse.buildSuccess(list)
    }

}