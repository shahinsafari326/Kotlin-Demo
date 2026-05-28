package com.shahin.interview

import com.shahin.interview.services.NotificationManager
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InterviewApplication

fun main(args: Array<String>) {
    val context = runApplication<InterviewApplication>(*args)
    val notificationManager = context.getBean(NotificationManager::class.java)
    notificationManager.sendNotification("test message")
}
