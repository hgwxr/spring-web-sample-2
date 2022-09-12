package com.hgwxr.springweb2.springwebsample2

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.bind.annotation.Mapping

@SpringBootApplication
@MapperScan("com.hgwxr.springweb2.springwebsample2.mapper")
@EntityScan(basePackages = ["com.hgwxr.springweb2.springwebsample2.db"])
@EnableJpaRepositories(basePackages = ["com.hgwxr.springweb2.springwebsample2.respository"])
class SpringWebSample2Application

fun main(args: Array<String>) {
    runApplication<SpringWebSample2Application>(*args)
}
