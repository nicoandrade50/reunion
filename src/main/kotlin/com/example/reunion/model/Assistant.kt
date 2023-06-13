package com.example.reunion.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table (name="assistant")

class Assistant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var fullname: String? = null
    var rol: String? = null
    var age: Long? = null
    @Column(name = "conference_id")
    var conferenceId: Long? = null
}