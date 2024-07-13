package com.example.a00_kotlinfundamentals.unit5_corrutinas

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {

    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")

            println(getWeatherReport())

            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}
//Manejo de Excepciones : se maneja solo para la funcion getTemperature().
/*   suspend private fun getWeatherReport() = coroutineScope {
   val forecast = async { getForecast() }
   val temperature = async {
       try {
           getTemperature()
       } catch (e: AssertionError) {
           println("Caught exception $e")
           "{ No temperature found }"
       }
   }

   "${forecast.await()} ${temperature.await()}"
}*/

//Cancelación:
suspend private fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }

    delay(200)
    temperature.cancel()

    "${forecast.await()}"
}


suspend private fun getForecast(): String {
    delay(3000)
    return ("Sunny")
}

suspend private fun getTemperature(): String {
    delay(500)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}
