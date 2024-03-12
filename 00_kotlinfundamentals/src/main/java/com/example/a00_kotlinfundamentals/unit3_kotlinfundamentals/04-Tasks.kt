package com.example.a00_kotlinfundamentals.unit3_kotlinfundamentals

enum class Daypart() {
    MORNING, AFTERNOON, EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

val events = mutableListOf<Event>(
    Event(
        title = "Wake up",
        description = "Time to get up",
        daypart = Daypart.MORNING,
        durationInMinutes = 0
    ),
    Event(
        title = "Eat breakfast",
        daypart = Daypart.MORNING,
        durationInMinutes = 15
    ),
    Event(
        title = "Learn about Kotlin",
        daypart = Daypart.AFTERNOON,
        durationInMinutes = 30
    ),
    Event(
        title = "Practice Compose",
        daypart = Daypart.AFTERNOON,
        durationInMinutes = 60
    ),
    Event(
        title = "Watch latest DevBytes video",
        daypart = Daypart.AFTERNOON,
        durationInMinutes = 10
    ),
    Event(
        title = "Check out latest Android Jetpack library",
        daypart = Daypart.EVENING,
        durationInMinutes = 45
    )
)
val Event.durationOfEvent: String
    get() =
        if (events[0].durationInMinutes < 60) {
            "short"
        } else {
            "long"
        }


fun main() {
    //val [type name}.[property name] : data type
    //property getter
    //ejemplos
    /*
    val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"
     */

    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}