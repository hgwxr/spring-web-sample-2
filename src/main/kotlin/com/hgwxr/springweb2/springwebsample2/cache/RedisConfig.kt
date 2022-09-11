package com.hgwxr.springweb2.springwebsample2.cache

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
@EnableRedisRepositories
class RedisConfig {

    @Bean
    fun getRedisFactory(): JedisConnectionFactory {
        val configuration = RedisStandaloneConfiguration("localhost", 6379)
        configuration.setPassword("123456")
        //        jedis.afterPropertiesSet()
        return JedisConnectionFactory(configuration)
    }

    @Bean
    fun getRedisTemplate(): RedisTemplate<String, Any> {
        val template = RedisTemplate<String, Any>()
        template.apply {
            setConnectionFactory(getRedisFactory())
            keySerializer = StringRedisSerializer()
            valueSerializer = StringRedisSerializer()
            hashKeySerializer = StringRedisSerializer()
            hashValueSerializer= JdkSerializationRedisSerializer()
            setEnableTransactionSupport(true)
            afterPropertiesSet()
        }
        return template
    }
}