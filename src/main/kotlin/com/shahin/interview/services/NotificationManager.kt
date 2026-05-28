package com.shahin.interview.services

import com.shahin.interview.interfaces.NotificationService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class NotificationManager (@param:Qualifier("SMSNotificationService") private var notificationService: NotificationService) {
    fun sendNotification(message: String) {
        notificationService.send(message)
    }

}