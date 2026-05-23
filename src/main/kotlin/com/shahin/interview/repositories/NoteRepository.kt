package com.shahin.interview.repositories

import com.shahin.interview.entities.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository: JpaRepository<Note, Long>{
    fun findByTitle(title: String): Note?

}