package com.example.a00_kotlinfundamentals.unit5_corrutinas

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            val forecast: Deferred<String> = async {
                getForecast()
            }
            val temperature: Deferred<String> = async {
                getTemperature()
            }
            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

suspend fun getForecast(): String {
    delay(1000)
    return ("Sunny")
}

suspend fun getTemperature(): String {
    delay(1000)
    return ("30\u00b0C")
}