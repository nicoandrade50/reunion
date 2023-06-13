package com.example.reunion.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table (name="conference")

class Conference {

@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
@Column(updatable = false)
var id: Long? = null

var title: String? = null
var description: String? = null
    var assistants: Long? = null
}