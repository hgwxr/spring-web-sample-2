package com.hgwxr.springweb2.springwebsample2

import com.hgwxr.springweb2.springwebsample2.mapper.DepartmentMapper
import com.hgwxr.springweb2.springwebsample2.mapper.EmployeeMapper
import org.apache.commons.logging.LogFactory
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource


@RunWith(SpringRunner::class)
@SpringBootTest
class SpringWebSample2ApplicationTests {
    val log = LogFactory.getLog(SpringWebSample2ApplicationTests::class.java)!!
    @Resource
    lateinit var departmentMapper: DepartmentMapper

    @Resource
    lateinit var employeeMapper: EmployeeMapper
    @Test
    fun contextLoads() {
    }
    @Test
    fun testFindAllEmployee(){
        log.info("testFindAllEmployee start ")
        val list = employeeMapper.findAllData()
        log.info("testFindAllEmployee end $list")
    }
    @Test
    fun testFindAllDepartment(){
        log.info("findAllData start ")
        val list = departmentMapper.findAllData()
        log.info("findAllData end $list")
    }

    /**
     * redis连接测试01
     */
    @Test
    fun redisTest01() {
        //连接本地的 Redis 服务
        val jedis = JedisConnectionFactory(RedisStandaloneConfiguration("localhost",6379))
        jedis.afterPropertiesSet()
        log.info("连接成功")
        log.info("创建 redisTemplate")
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(jedis)
        //查看服务是否运行
        log.info("服务正在运行: $jedis")
    }

}
