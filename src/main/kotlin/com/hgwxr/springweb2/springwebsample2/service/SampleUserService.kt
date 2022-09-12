package com.hgwxr.springweb2.springwebsample2.service

import com.hgwxr.springweb2.springwebsample2.db.SampleUser
import com.hgwxr.springweb2.springwebsample2.respository.SampleUserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SampleUserService {

    @Autowired
    private lateinit var _sampleUserDao:SampleUserDao
    fun getAll() :List<SampleUser>{
        return _sampleUserDao.findAll()
    }

    fun save(sampleUser: SampleUser){
        _sampleUserDao.save(sampleUser)
    }
    fun delById(id: Int){
        _sampleUserDao.deleteById(id)
    }
}