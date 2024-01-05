package com.example.cursoandroidcompose.practiceKotlinFundamentals


fun main() {

    val celsiusToFahrenheit: (Double) -> Double = { celsius -> (9 / 5.toDouble() * celsius) + 32 }
    val kelvinToCelsius: (Double) -> Double = { kelvin -> (kelvin - 273.15) }
    val fahrenheitToKelvin: (Double) -> Double = { f -> (5 / 9.toDouble() * f - 32) + 273.15 }

    printFinalTemperature(
        initialMeasurement = 27.0,
        initialUnit = "Cesius",
        finalUnit = "Farenheit",
        celsiusToFahrenheit
    )
    printFinalTemperature(350.0, "Kelvin", "Celsius", kelvinToCelsius)
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", fahrenheitToKelvin)
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement =
        String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}