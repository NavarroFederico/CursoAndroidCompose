package com.example.cursoandroidcompose.practiceKotlinFundamentals.united3

class Cookie(
    val name: String, val softBaked: Boolean, val hasFilling: Boolean, val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip", softBaked = false, hasFilling = false, price = 1.69
    ), Cookie(
        name = "Banana Walnut", softBaked = true, hasFilling = false, price = 1.49
    ), Cookie(
        name = "Vanilla Creme", softBaked = false, hasFilling = true, price = 1.59
    ), Cookie(
        name = "Chocolate Peanut Butter", softBaked = false, hasFilling = true, price = 1.49
    ), Cookie(
        name = "Snickerdoodle", softBaked = true, hasFilling = false, price = 1.39
    ), Cookie(
        name = "Blueberry Tart", softBaked = true, hasFilling = true, price = 1.79
    ), Cookie(
        name = "Sugar and Sprinkles", softBaked = false, hasFilling = false, price = 1.39
    )
)

fun main() {
    /*
      La función fold() se usa para generar un valor único a partir de una colección.
      Por lo general, se usa para calcular un total de precios o sumar todos los elementos de una lista
       para encontrar un promedio..*/


    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}