package com.example.cursoandroidcompose

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    // Fill in the code.
    when {
        numberOfMessages in 1..99 -> println("You have $numberOfMessages notifications.")
        (numberOfMessages > 99) -> println("Your phone is blowing up! You have 99+ notifications.")
    }
}