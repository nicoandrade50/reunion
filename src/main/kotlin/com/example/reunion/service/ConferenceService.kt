package com.example.reunion.service

import com.example.reunion.model.Conference
import com.example.reunion.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.server.ResponseStatusException

@Controller
class ConferenceService {

    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list(): List<Conference> {
        return conferenceRepository.findAll()

    }

    @PostMapping
    fun save(@RequestBody conference: Conference): Conference {

        return conferenceRepository.save(conference)

    }

    @PutMapping
    fun update(conference: Conference): Conference {
        try {
            conferenceRepository.findById(conference.id)
                    ?: throw Exception("ID no existe")

            return conferenceRepository.save(conference)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    @PatchMapping

    fun updateName(conference: Conference): Conference {
        try {
            val response = conferenceRepository.findById(conference.id)
                    ?: throw Exception("Id Existe")
            response.apply {
                title = conference.title
            }
            return conferenceRepository.save(conference)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}


