package com.shahin.interview.controllers

import com.shahin.interview.dtos.SaveNoteRequest
import com.shahin.interview.entities.Note
import com.shahin.interview.services.NoteService
import jakarta.validation.Valid
import lombok.AllArgsConstructor
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
class NotesController (private val noteService: NoteService) {

     @PostMapping
     fun saveNote(@Valid @RequestBody note: SaveNoteRequest) : ResponseEntity<Note> {
         val savedNote = noteService.saveNote(note)
         val uri = URI.create("/notes/${savedNote.id}")
         return ResponseEntity.created(uri).body(savedNote)
     }

    @GetMapping
    fun getNotes(
        @RequestParam (defaultValue = "0") page: Int,
        @RequestParam (defaultValue = "5") size: Int) : ResponseEntity<List<Note>> {
        val pageAble = PageRequest.of(page, size, Sort.Direction.ASC, "createdAt")
        val noteList = noteService.getNotes(pageAble)
        return ResponseEntity.status(HttpStatus.OK).body(noteList.content)
    }

    @PatchMapping("/{noteId}")
    fun updateNote(@Valid @RequestBody note: SaveNoteRequest, @PathVariable noteId: Long) : ResponseEntity<Note> {
        val updatedNote = noteService.updateNote(note, noteId)
        return ResponseEntity.status(HttpStatus.OK).body(updatedNote)
    }

}