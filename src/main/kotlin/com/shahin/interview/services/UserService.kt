package com.shahin.interview.services

import com.shahin.interview.dtos.LoginUserRequest
import com.shahin.interview.exceptions.NoteAlreadyExistException
import com.shahin.interview.dtos.SaveNoteRequest
import com.shahin.interview.dtos.SaveUserRequest
import com.shahin.interview.entities.Note
import com.shahin.interview.entities.User
import com.shahin.interview.exceptions.NoteNotFoundException
import com.shahin.interview.exceptions.UserAlreadyExistException
import com.shahin.interview.repositories.NoteRepository
import com.shahin.interview.repositories.UserRepository
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@Transactional
class UserService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder
) : UserDetailsService {

    fun saveUser(request: SaveUserRequest): User {
        // Check if user exist
        val user = userRepository.findByEmail(request.email)
        if (user != null) {
            throw UserAlreadyExistException()
        }
        val hashedPassword = passwordEncoder.encode(request.password)
        val newUser = User (
            email  = request.email,
            passwordHash = hashedPassword!!
        )
        return userRepository.save(newUser)
    }

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository.findByEmail(email)
            ?: throw UsernameNotFoundException("User not found")

        return org.springframework.security.core.userdetails.User(
            user.email,
            user.passwordHash,
            emptyList()
        )
    }


}