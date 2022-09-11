package com.hgwxr.springweb2.springwebsample2.entity


data class Department(val id:Int,val departmentName:String):java.io.Serializable
data class Employee(val id:Int,val lastName:String,val email:String,val gender:Int,val department: Int,var birth:Long):java.io.Serializable