package com.example.reunion.service

import com.example.reunion.model.Assistant
import com.example.reunion.repository.AssistantRepository
import com.example.reunion.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.server.ResponseStatusException

@Service
class AssistantService {

    @Autowired
    lateinit var assistantRepository: AssistantRepository

    @Autowired
    lateinit var conferenceRepository: ConferenceRepository


    fun list(): List<Assistant> {
        return assistantRepository.findAll()

    }

    @PutMapping
    fun update(assistant: Assistant): Assistant {
        try {
            assistantRepository.findById(assistant.id)
                    ?: throw Exception("ID no existe")

            return assistantRepository.save(assistant)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    @PatchMapping
    fun updateName(assistant: Assistant): Assistant {
        try {
            val response = assistantRepository.findById(assistant.id)
                    ?: throw Exception("Id no Existe")
            response.apply {
                fullname = assistant.fullname
            }
            return assistantRepository.save(assistant)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    @PostMapping
    fun save(assistant: Assistant): Assistant {
        try {
            val responseConference = conferenceRepository.findById(assistant.conferenceId)
                    ?: throw Exception("Id no Existe")

            val responseAssistant = assistantRepository.save(assistant)

            val totalAssistant = getTotalAssistant(assistant.conferenceId)



            return responseAssistant
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun getTotalAssistant(conferenceId: Long?): Double? {
        return assistantRepository.getTotalAssistant(conferenceId)
    }
}