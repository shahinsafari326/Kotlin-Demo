package com.shahin.interview.controllers

import com.shahin.interview.exceptions.NoteAlreadyExistException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ExceptionHandler (NoteAlreadyExistException::class)
    fun handleNoteAlreadyExistException(ex: NoteAlreadyExistException): ResponseEntity<Map<String, String>>{
        return ResponseEntity.status(HttpStatus.CONFLICT).body(mapOf("error" to "Note with this title already exists"))
    }

    @ExceptionHandler (MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String>>{
        val errors = ex.bindingResult.fieldErrors.associate {it.field to (it.defaultMessage ?:"Invalid value")}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }

    @ExceptionHandler (HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<Map<String, String>>{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapOf("error" to "Please provide all required fields"))
    }
}