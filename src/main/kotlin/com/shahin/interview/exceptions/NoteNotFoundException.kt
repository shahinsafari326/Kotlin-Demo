package com.shahin.interview.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NoteNotFoundException(
    message: String
) : RuntimeException(message)