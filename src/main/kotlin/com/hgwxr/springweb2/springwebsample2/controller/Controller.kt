package com.hgwxr.springweb2.springwebsample2.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @RequestMapping("/helloworld")
    fun  helloWorld():String{
        return "hello world";
    }

}