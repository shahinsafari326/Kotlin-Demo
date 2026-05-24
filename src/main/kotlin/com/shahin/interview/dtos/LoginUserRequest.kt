package com.shahin.interview.dtos

import jakarta.annotation.Nonnull
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginUserRequest(

    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Email must be valid")
    val email: String,

    @field:NotBlank(message = "Password is required")
    @field:Nonnull
    val password: String
)
