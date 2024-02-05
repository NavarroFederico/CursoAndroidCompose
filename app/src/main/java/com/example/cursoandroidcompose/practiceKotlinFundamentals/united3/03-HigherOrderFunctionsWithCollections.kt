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
       La función filter() te permite crear un subconjunto de una colección.
       Por ejemplo, si tuvieras una lista de números, podrías usar filter()
       para crear una lista nueva que solo contenga números divisibles por 2.
.*/

    val softBakedMenu = cookies.filter {
        it.softBaked
    }
    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
}