package com.shahin.interview.controllers

import com.shahin.interview.dtos.LoginUserRequest
import com.shahin.interview.services.AuthService
import com.shahin.interview.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginUserRequest): ResponseEntity<String> {
        return ResponseEntity.ok(authService.login(request))
    }
}