package com.shahin.interview.controllers

import com.shahin.interview.dtos.SaveNoteRequest
import com.shahin.interview.dtos.SaveUserRequest
import com.shahin.interview.dtos.SaveUserResponse
import com.shahin.interview.entities.Note
import com.shahin.interview.repositories.UserRepository
import com.shahin.interview.services.NoteService
import com.shahin.interview.services.UserService
import jakarta.validation.Valid
import lombok.AllArgsConstructor
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@AllArgsConstructor
@RequestMapping("/users")
class UserController (private val userService: UserService) {

    @PostMapping
    fun saveUser(@Valid @RequestBody userRequest: SaveUserRequest) : ResponseEntity<SaveUserResponse> {
        val savedUser = userService.saveUser(userRequest)
        val uri = URI.create("/user/${savedUser.id}")
        val response = SaveUserResponse (
            email = savedUser.email,
        )
        return ResponseEntity.created(uri).body(response)
    }

}