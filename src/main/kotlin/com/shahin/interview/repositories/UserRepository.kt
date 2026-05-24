package com.shahin.interview.repositories

import com.shahin.interview.entities.Note
import com.shahin.interview.entities.User
import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>{
    fun findByEmail(email: String): User?

}