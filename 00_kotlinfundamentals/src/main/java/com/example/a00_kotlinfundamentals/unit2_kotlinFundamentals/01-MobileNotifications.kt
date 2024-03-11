package com.example.a00_kotlinfundamentals.unit2_kotlinFundamentals

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
/*
//Codigo de Solución propuesto
fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        println("You have ${numberOfMessages} notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}*/
