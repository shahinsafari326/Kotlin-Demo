package com.shahin.interview.services

import com.shahin.interview.interfaces.NotificationService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class NotificationManager (@param:Qualifier("SMSNotificationService") private var notificationService: NotificationService) {

    @Value("\${message-gateway}")
    var messageGateway: String? = null

    fun sendNotification(message: String) {
        print("Sending notification using $messageGateway")
        notificationService.send(message)
    }

}