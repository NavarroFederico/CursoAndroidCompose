package com.example.a00_kotlinfundamentals.unit3_kotlinfundamentals

fun main() {

    //key = planet , value = moons
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println(solarSystem.size)
    //Agrego un valor nuevo a la coleccion map
    solarSystem["Pluto"] = 5

    println(solarSystem.size)

    //Busco el indice donde se encuentra el elemento con clave pluto
    println(solarSystem["Pluto"])

    //tambien se puede acceder con get(). sino está devuelve un null
    println(solarSystem.get("Theia"))

    //remove
    solarSystem.remove("Pluto")
    println(solarSystem.size)

    /*La sintaxis de subíndice, o el método put(),
    también puede modificar el valor de una clave que ya existe.
    Usa la sintaxis de subíndice para actualizar las lunas de Júpiter a 78 y
     muestra el nuevo valor.*/
    solarSystem["Jupiter"] = 78
    println(solarSystem["Jupiter"])

}