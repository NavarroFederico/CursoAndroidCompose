package com.example.a00_kotlinfundamentals.unit5_corrutinas

/*
* JOB
* Job. Dicha instancia contiene un controlador o referencia de la corrutina para que
* puedas administrar su ciclo de vida
*
*val job = launch { ... }
*
*job.cancel()
*
* Con un trabajo, puedes verificar si está activo, cancelado o completado.
* El trabajo se completa si la corrutina y las corrutinas que inició completaron toda la tarea.
* Ten en cuenta que la corrutina podría haberse completado por un motivo diferente,
* por ejemplo, porque se canceló o falló con una excepción,
* pero el trabajo todavía se considera completado en ese momento.
*
* Los trabajos también realizan un seguimiento de la relación superior-secundaria entre las corrutinas.
*
* JERARQUÍAS DE LOS JOBS
*
*val job = launch {
    ...

    val childJob = launch { ... }

    ...
}
* _Si se cancela un trabajo superior, también se cancelan sus trabajos secundarios.
* _Cuando se cancela un trabajo secundario con job.cancel(), este finaliza, pero no se cancela su superior.
* _Si un trabajo falla con una excepción, cancela a su superior con esa excepción, lo que se conoce
* como propagación del error en sentido ascendente (hasta el trabajo superior, el superior del superior y así sucesivamente) .
*
*
* COROUTINESCOPE
*Un CoroutineScope está vinculado a un ciclo de vida, que establece límites sobre la duración en la
* que estarán activas las corrutinas dentro de ese alcance.
* Si se cancela un alcance, el trabajo se cancela,
* y la cancelación se propaga a los trabajos secundarios.
* Si un trabajo secundario en el alcance falla con una excepción, otros trabajos secundarios y
* el trabajo superior se cancelan, y la excepción se vuelve a arrojar al llamador.
*
*
* CoroutineContext
CoroutineContext proporciona información sobre el contexto en el que se ejecutará la corrutina. En esencia, CoroutineContext es un mapa que almacena elementos en los que cada uno tiene una clave única. Estos campos no son obligatorios, pero estos son algunos ejemplos de lo que puede contener un contexto:

Name: Es el nombre de la corrutina para identificarla de forma única.
Job: Controla el ciclo de vida de la corrutina.
Dispatchers: Envía la tarea al subproceso correspondiente.
Exception handler: Maneja las excepciones que arroja el código ejecutado en la corrutina.
*
* Dispatchers : envia o asigna la tarea a un subproceso.
*
* Kotlin proporciona algunos despachadores integrados:

Dispatchers.Main: Utiliza este despachador para ejecutar una corrutina en el subproceso principal de Android. Este despachador se usa principalmente para manejar interacciones y actualizaciones de la IU, así como realizar tareas rápidas.
Dispatchers.IO: Este despachador está optimizado para realizar E/S de disco o red fuera del subproceso principal. Por ejemplo, leer archivos o escribir en estos, y ejecutar cualquier operación de red.
Dispatchers.Default: Es un despachador predeterminado que se usa al llamar a launch() y async(), cuando no se especifica un despachador en su contexto. Puedes usar este despachador para realizar tareas intensivas a nivel computacional fuera del subproceso principal. Por ejemplo, el procesamiento de un archivo de imagen de mapa de bits.
* */

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    runBlocking {
        println("${Thread.currentThread().name} - runBlocking function")
        launch {
            println("${Thread.currentThread().name} - launch function")
            withContext(Dispatchers.Default) {
                println("${Thread.currentThread().name} - withContext function")
                delay(1000)
                println("10 results found.")
            }
            println("${Thread.currentThread().name} - end of launch function")
        }
        println("Loading...")
    }
}