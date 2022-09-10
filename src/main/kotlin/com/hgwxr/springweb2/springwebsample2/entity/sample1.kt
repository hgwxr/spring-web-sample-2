package com.hgwxr.springweb2.springwebsample2.entity

import java.sql.Date

data class Department(val id:Int,val departmentName:String)

data class Employee(val id:Int,val lastName:String,val email:String,val gender:Int,val department: Int,var birth:Date)