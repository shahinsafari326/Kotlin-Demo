package com.shahin.interview.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class SaveUserResponse(

    val email: String,
)
