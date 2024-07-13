package com.example.a00_kotlinfundamentals.unit5_corrutinas

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
Ahora cambiaste tu código síncrono a asíncrono. Cuando se muestra una función asíncrona,
es posible que la tarea aún no se haya completado. Esto es lo que observaste en el caso de launch().
Se mostró la función, pero la tarea aún no se completó. Si usas launch(),
se pueden ejecutar varias tareas en tu código de forma simultánea,
lo que es una capacidad eficaz que puedes usar en las apps para Android que desarrollas.
*/
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

suspend private fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    "${forecast.await()} ${temperature.await()}"
}

suspend private fun getForecast(): String {
    delay(3000)
    return ("Sunny")
}

suspend private fun getTemperature(): String {
    delay(1000)
    return ("30\u00b0C")
}