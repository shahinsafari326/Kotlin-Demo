package com.shahin.interview.services

import com.shahin.interview.interfaces.NotificationService
import org.springframework.stereotype.Service

@Service ("SMSNotificationService")
class SMSNotificationService : NotificationService {
    override fun send(message: String) {
        println("Sending SMS $message")
    }
}