package com.hgwxr.springweb2.springwebsample2

import com.hgwxr.springweb2.springwebsample2.entity.Department
import com.hgwxr.springweb2.springwebsample2.mapper.DepartmentMapper
import com.hgwxr.springweb2.springwebsample2.mapper.EmployeeMapper
import com.hgwxr.springweb2.springwebsample2.respository.DepartmentDao
import org.apache.commons.logging.LogFactory
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource


@RunWith(SpringRunner::class)
@SpringBootTest(classes = [SpringWebSample2Application::class])
class SpringWebSample2ApplicationTests {
    val log = LogFactory.getLog(SpringWebSample2ApplicationTests::class.java)!!
    @Resource
    lateinit var departmentMapper: DepartmentMapper

    @Resource
    lateinit var employeeMapper: EmployeeMapper
    @Test
    fun contextLoads() {
    }
    @Resource
    private var dao : DepartmentDao?=null
    @Resource
    private var redisTemplate: RedisTemplate<String, Any>? = null
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
        if (redisTemplate == null) {
            log.info("redisTemplate: empty")
        }else{
            log.info("连接成功")
        }
    }
    /**
     * redis连接测试01
     */
    @Test
    fun redisTest02() {
        if (dao == null) {
            log.info("redisTemplate: empty")
        }else{
            log.info("连接成功")
        }
    }
    @Test
    fun redisTest3() {
        if (dao == null) {
            log.info("redisTemplate: empty")
            return
        }

        dao?.apply {
             val d = save(Department(1001,"生产厨师部门"))
            log.info("redisTemplate: d:${d.toString()}")
            val departments = findAll()
            log.info("redisTemplate: departments:${departments.toString()}")
            val d1 = findById(d.id)
            log.info("redisTemplate: d1:${d1.toString()}")

//            if (d1 != null) {
//                val  del = delById(d1.id)
//                log.info("redisTemplate: del:${del.toString()}")
//            }
            log.info("redisTemplate: d1:${d1.toString()}")
        }
    }
}
