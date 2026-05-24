package com.shahin.interview

import com.shahin.interview.entities.Note
import com.shahin.interview.repositories.NoteRepository
import jakarta.transaction.Transactional
import junit.framework.TestCase.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.Test
import kotlin.test.assertNotNull

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class NoteServiceIntegrationTest {
    @Autowired
    lateinit var noteRepository: NoteRepository

    @Test
    fun shouldSaveNote() {
        val title = "Hello"

        val saved = noteRepository.save(
            Note(
                title = title,
                content = "World"
            )
        )

        assertNotNull(saved.id)

        val fromDb = noteRepository.findById(saved.id)

        assertTrue(fromDb.isPresent)
        assertEquals(title, fromDb.get().title)
    }
}