package com.example.a00_kotlinfundamentals.unit2_kotlinFundamentals

fun main() {
    //   val coins: (Int) -> String = {  "$it quarters" }
    val cupcake: (Int) -> String = { "Have a cupcake!" }

    val treatFunction = trickOrTreat(isTrick = false, extraTreat = { "$it quarters" })
    treatFunction()

    val trickFunction = trickOrTreat(isTrick = true, null)
    trickFunction()

    repeat(4) {
        treatFunction()
    }
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}