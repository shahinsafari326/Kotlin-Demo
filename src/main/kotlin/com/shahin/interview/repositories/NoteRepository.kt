package com.shahin.interview.repositories

import com.shahin.interview.entities.Note
import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository: JpaRepository<Note, Long>{
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    fun findByTitle(title: String): Note?

}