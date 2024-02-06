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
//Asi lo resolví yo
    val groupedByDaypart = events.groupBy { it.daypart }
    val morning = groupedByDaypart[Daypart.MORNING] ?: listOf()
    val afternoon = groupedByDaypart[Daypart.AFTERNOON] ?: listOf()
    val evening = groupedByDaypart[Daypart.EVENING] ?: listOf()

    println("Morning: ${morning.size} events")
    println("Afternoon: ${afternoon.size} events")
    println("Evening: ${evening.size} events")

//Solucion propuesta
    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
}
