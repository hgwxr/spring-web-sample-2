package com.hgwxr.springweb2.springwebsample2.cache

import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

object RedisConfig {
    private fun getRedisFactory(): JedisConnectionFactory {
        val jedis = JedisConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))
        jedis.afterPropertiesSet()
        return jedis
    }

    fun getRedisTemplate(): RedisTemplate<String, Any> {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(getRedisFactory())
        return template
    }
}