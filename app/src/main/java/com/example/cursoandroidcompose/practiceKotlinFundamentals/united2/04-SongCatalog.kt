package com.example.cursoandroidcompose.practiceKotlinFundamentals.united2

import java.time.Year
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Song(
    private val title: String,
    private val artist: Artist,
    private val yearPublished: Year,
    private val playCount: Int,

    ) {
    private val isPopular by IsPopularDelegate(playCount)

    fun printSong() {
        println("$title, performed by ${artist.name}, was released in $yearPublished. ${if (isPopular) "Popular" else "Unpopular."}")
    }
}

class IsPopularDelegate(private var playCount: Int) : ReadOnlyProperty<Any?, Boolean> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): Boolean {
        return playCount > 1000
    }
}

class Artist(
    val name: String = "default"
) {

}

fun main() {

    val song = Song("Si te vas", Artist("Los Guaracheros del Amor"), Year.of(2023), 200)
    song.printSong()

}

/*
//Solucion propuesta
fun main() {
    val brunoSong = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)
    brunoSong.printDescription()
    println(brunoSong.isPopular)
}

class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
){
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}*/
