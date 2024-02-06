package com.example.cursoandroidcompose.practiceKotlinFundamentals.united3

enum class Daypart() {
    MORNING, AFTERNOON, EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

fun main() {
    println(
        Event(
            title = "Study Kotlin",
            description = "Commit to studying Kotlin atleast 15 minutes per day",
            daypart = Daypart.EVENING,
            durationInMinutes = 15
        )
    )
}