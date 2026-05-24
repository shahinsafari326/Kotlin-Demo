package com.shahin.interview.services

import com.shahin.interview.dtos.LoginUserRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val authenticationManager: AuthenticationManager
) {


    fun login(request: LoginUserRequest): String {

        val authToken = UsernamePasswordAuthenticationToken(
            request.email,
            request.password
        )

        val authentication = authenticationManager.authenticate(authToken)

        if (!authentication.isAuthenticated) {
            throw BadCredentialsException("Invalid credentials")
        }

        return "LOGIN SUCCESS"
    }
}