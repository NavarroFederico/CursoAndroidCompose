package com.example.a00_kotlinfundamentals.unit5_corrutinas

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            printForecast()
            printTemperature()
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

suspend private fun printForecast() {
    delay(1000)
    println("Sunny")
}

suspend private fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}
