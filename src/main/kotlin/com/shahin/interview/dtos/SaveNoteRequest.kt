package com.shahin.interview.dtos

import jakarta.validation.constraints.NotBlank

data class SaveNoteRequest(
    @field:NotBlank (message = "Title is required")
    val title: String,

    @field:NotBlank (message = "Content is required")
    val content: String,
)
