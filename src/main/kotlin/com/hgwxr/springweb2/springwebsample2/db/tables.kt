package com.hgwxr.springweb2.springwebsample2.db

import javax.persistence.*

@Entity
@Table(name = "sample_user")
class SampleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    lateinit var name: String
    lateinit var email: String
}