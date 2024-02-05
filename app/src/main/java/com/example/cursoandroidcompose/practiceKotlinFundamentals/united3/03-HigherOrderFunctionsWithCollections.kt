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
       La función groupBy() se puede usar para convertir una lista en un mapa con base en una función.
        Cada valor único que se muestra de la función se convierte en una clave en el mapa resultante.
        Los valores de cada clave son todos los elementos de la colección que produjeron ese valor único.
.*/

    val groupedMenu = cookies.groupBy { it.softBaked }

    /*Crea una variable softBakedMenu que contenga el valor de groupedMenu[true] y
    una variable crunchyMenu que contenga el valor de groupedMenu[false].
    Como el resultado de suscribir un elemento Map puede ser nulo, puedes usar el operador Elvis (?:)
    para mostrar una lista vacía.*/

    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println()
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }
}