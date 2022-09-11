package com.hgwxr.springweb2.springwebsample2.respository

import com.hgwxr.springweb2.springwebsample2.entity.Department
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository


@Repository
class DepartmentDao {

    companion object {
        const val HASH_KEY = "Department"
    }

    @Autowired
    private var redisTemplate: RedisTemplate<String, Any>? = null


    fun save(department: Department): Department {
        redisTemplate?.opsForHash<String, Any>()?.put(HASH_KEY, department.id.toString(), department)
        return department
    }

    fun findAll(): MutableList<Department>? {
        return redisTemplate?.opsForHash<String, Department>()?.values(HASH_KEY)
    }

    fun findById(id: Int): Department? {
        return redisTemplate?.opsForHash<String, Department>()?.get(HASH_KEY, id.toString())
    }

    fun delById(id: Int): Int {
        redisTemplate?.opsForHash<String, Department>()?.delete(HASH_KEY, id.toString())
        return id
    }

}