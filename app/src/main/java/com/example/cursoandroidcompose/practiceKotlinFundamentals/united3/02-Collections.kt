package com.example.cursoandroidcompose.practiceKotlinFundamentals.united3

fun main() {
    val solarSystem =
        listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    //.size propiedad para acceder a la cantidad de elementos que tiene una lista

    println(solarSystem.size)

    println(solarSystem[2])
    println(solarSystem.get(3))

    //devuelve el index de un elemento que contenga "Earth"
    println(solarSystem.indexOf("Earth"))

    //sino se encuentra devuelve -1
    println(solarSystem.indexOf("Pluto"))

    //uso de for
    println("lista recorrida por un for")
    for (planet in solarSystem) {
        println(planet)
    }

    //agregar elementos a una mutablelist
    val solarSystem1 =
        mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    //.add() " formas de llamar a add()
    solarSystem1.add("Pluto")

    solarSystem1.add(3, "Theia")

    //Actualizando valores
    solarSystem1[3] = "Future Moon"

    println(solarSystem1[3])
    println(solarSystem1[9])

    //Eliminar elementos
    solarSystem1.removeAt(9)

    solarSystem1.remove("Future Moon")

    //devuelve booleano si se encuentra elemento en la lista
    println(solarSystem1.contains("Pluto"))

    //similar a contains operador in
    println("Future Moon" in solarSystem1)


}
