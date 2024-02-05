package com.example.cursoandroidcompose.practiceKotlinFundamentals.united3

fun main() {

    //Crea un Set de planetas llamado solarSystem con mutableSetOf(). Esto muestra un MutableSet, cuya implementación predeterminada es LinkedHashSet().
    val solarSystem =
        mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println(solarSystem.size)

    solarSystem.add("Pluto")

    println(solarSystem.size)

    println(solarSystem.contains("Pluto"))

    println("Pluto" in solarSystem)

    //intentando agregar algo que ya existe
    solarSystem.add("Pluto")
    println(solarSystem.size)

    //remove un valor que toma por parametro
    solarSystem.remove("Pluto")

    //consulta si pluto está
    println(solarSystem.size)
    println(solarSystem.contains("Pluto"))

}
