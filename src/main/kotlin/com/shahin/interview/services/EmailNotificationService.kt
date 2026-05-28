package com.shahin.interview.services

import com.shahin.interview.interfaces.NotificationService
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service("EmailNotificationService")
@Primary
class EmailNotificationService: NotificationService {
    override fun send(message: String) {
        println("Sending email $message")
    }
}