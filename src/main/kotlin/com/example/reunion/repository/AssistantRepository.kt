package com.example.reunion.repository

import com.example.reunion.model.Assistant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository

interface AssistantRepository: JpaRepository<Assistant, Long> {

    fun findById (id: Long?): Assistant?

    @Query(nativeQuery =true)//Va a leer jpa-named.....
    fun getTotalAssistant(@Param("conference_id") conferenceId: Long?): Double?

}