package com.shahin.interview.controllers

import com.shahin.interview.dtos.SaveNoteRequest
import com.shahin.interview.entities.Note
import com.shahin.interview.services.NoteService
import jakarta.validation.Valid
import lombok.AllArgsConstructor
import org.hibernate.validator.constraints.URL
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
class NotesController (private val noteService: NoteService) {

     @PostMapping("/save")
     fun saveNote(@Valid @RequestBody note: SaveNoteRequest) : ResponseEntity<Note> {
         val savedNote = noteService.saveNote(note)
         val uri = URI.create("/notes/${savedNote.id}")
         return ResponseEntity.created(uri).body(savedNote)
     }
}