package com.example.reunion.controller

import com.example.reunion.model.Assistant
import com.example.reunion.service.AssistantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping ("/assistant")

class AssistantController {

@Autowired
    lateinit var assistantService: AssistantService

    @GetMapping
    fun list(): ResponseEntity<*> {
        return ResponseEntity(assistantService.list(), HttpStatus.OK)

    }

    @PostMapping
    fun save(@RequestBody assistant: Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.save(assistant), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody assistant: Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.update(assistant), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody assistant: Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.updateName(assistant), HttpStatus.OK)
    }

}