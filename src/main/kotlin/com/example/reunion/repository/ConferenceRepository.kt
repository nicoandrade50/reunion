package com.example.reunion.repository

import com.example.reunion.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface ConferenceRepository:JpaRepository<Conference, Long> {

    fun findById(id: Long?): Conference?

}