package com.shahin.interview.services

import com.shahin.interview.interfaces.NotificationService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class NotificationManager(
    private val notificationServices: Map<String, NotificationService>, // sprin automatically creates this map

    @param:Value("\${message-gateway:EmailNotificationService}") // default EmailNotificationService
    private val provider: String
) {

    fun sendNotification(message: String) {
        val service = notificationServices[provider]
            ?: throw IllegalArgumentException("Unknown provider: $provider")

        service.send(message)
    }
}