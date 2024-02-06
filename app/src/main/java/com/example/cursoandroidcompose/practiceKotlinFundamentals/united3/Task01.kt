package com.example.cursoandroidcompose.practiceKotlinFundamentals.united3


data class Event(
    val title: String,
    val description: String?,
    val daypart: String,
    val durationInMinutes: Int
)

fun main() {
    println(
        Event(
            title = "Study Kotlin",
            description = "Commit to studying Kotlin atleast 15 minutes per day",
            daypart = "Evening",
            durationInMinutes = 15
        )
    )
}