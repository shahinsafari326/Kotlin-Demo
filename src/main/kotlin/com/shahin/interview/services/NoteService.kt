package com.shahin.interview.services

import com.shahin.interview.NoteAlreadyExistException
import com.shahin.interview.dtos.SaveNoteRequest
import com.shahin.interview.entities.Note
import com.shahin.interview.repositories.NoteRepository
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
@Transactional
class NoteService(private val noteRepository: NoteRepository) {

    fun saveNote(noteToSave: SaveNoteRequest): Note {
        // Check if note exist
        val note = noteRepository.findByTitle(noteToSave.title)
        if (note != null) {
            throw NoteAlreadyExistException()
        }

        val newNote = Note(
            title = noteToSave.title,
            content = noteToSave.content,
        )
        return noteRepository.save(newNote)
    }

    fun getNotes(pageAble: PageRequest): Page<Note> {
        return noteRepository.findAll(pageAble)
    }
}