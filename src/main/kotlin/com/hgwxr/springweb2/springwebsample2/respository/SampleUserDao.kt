package com.hgwxr.springweb2.springwebsample2.respository

import com.hgwxr.springweb2.springwebsample2.db.SampleUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SampleUserDao :JpaRepository<SampleUser,Int>{
}