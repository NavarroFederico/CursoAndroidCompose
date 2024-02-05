package com.example.cursoandroidcompose.practiceKotlinFundamentals.united3

class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 =
        Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}
//las propiedades de extension no pueden almacenar datos, por lo que deben ser de solo acceso
val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"

fun main() {

    /*    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 =
            Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

        println(question1.toString())
        println(question2.toString())
        println(question3.toString())
        */
    println(Quiz.progressText)


}