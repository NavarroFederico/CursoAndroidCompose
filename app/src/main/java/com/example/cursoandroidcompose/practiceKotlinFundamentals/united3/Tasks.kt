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
    /*    var count: Int = 0
        events.forEach {
            println("Event ${++count}")
            println(
                "Title: ${it.title}, Daypart: ${it.daypart},durationMinutes ${it.durationInMinutes}"
            )
        }*/
    val eventsShort = events.filter { it.durationInMinutes < 60 }
    println("Count short event: ${eventsShort.size}")
    eventsShort.forEach {
        println()
        println(
            "Title: ${it.title}, Daypart: ${it.daypart},durationMinutes ${it.durationInMinutes}"
        )
    }
}