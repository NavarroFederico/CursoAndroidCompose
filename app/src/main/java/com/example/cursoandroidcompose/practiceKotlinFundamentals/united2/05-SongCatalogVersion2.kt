package com.example.cursoandroidcompose.practiceKotlinFundamentals.united2

import java.time.Year
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Song2(
    private val title: String,
    private val artist: Artist,
    private val yearPublished: Year,
    private val playCount: Int,

    ) {
    private val isPopular by IsPopularDelegate2(playCount)

    fun printSong() {
        println("$title, performed by ${artist.name}, was released in $yearPublished. $isPopular")
    }
}

class IsPopularDelegate2(private var playCount: Int) : ReadOnlyProperty<Any?, String> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return if (playCount > 1000) "Popular" else "Unpopular"
    }
}

class Artist2(
    val name: String = "default"
) {

}

fun main() {

    val song = Song2("Un Hombre Normal", Artist("Los Guaracheros del Amor"), Year.of(2024), 1_500)
    song.printSong()

}