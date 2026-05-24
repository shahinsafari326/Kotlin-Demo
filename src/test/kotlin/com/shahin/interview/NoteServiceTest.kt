package com.shahin.interview

import com.shahin.interview.dtos.SaveNoteRequest
import com.shahin.interview.entities.Note
import com.shahin.interview.repositories.NoteRepository
import com.shahin.interview.services.NoteService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NoteServiceTest {

    private val noteRepository = mockk<NoteRepository>()

    private val noteService = NoteService(noteRepository)

    @Test
    fun `should create note`() {

        val note = Note(
            id = 1,
            title = "Hello",
            content = "World"
        )

        val noteRequest = SaveNoteRequest(
            title = "Hello",
            content = "World"
        )

        every {
            noteRepository.findByTitle("Hello")
        } returns null

        every {
            noteRepository.save(any())
        } returns note

        val result = noteService.saveNote(noteRequest)

        assertEquals("Hello", result.title)

        verify(exactly = 1) {
            noteRepository.save(any())
        }
    }
}