package com.example.a10_dessertclicker.ui

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.a10_dessertclicker.R
import com.example.a10_dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel() : ViewModel() {
    //Solo es accesible y editable desde **..ViewModel
    private val _uiState = MutableStateFlow(DessertClickerUIState())

    //Propiedad de solo lectura para IU se inicializa con el valor de _uiState.asStateFlow()
    val uiState: StateFlow<DessertClickerUIState> = _uiState.asStateFlow()


    /**
     * Maneja el evento de clic en un postre.
     *
     * Esta función se activa cuando el usuario hace clic en un elemento de la lista de postres.
     * Actualiza el estado de la interfaz de usuario (`_uiState`) relacionado con los postres,
     * incluyendo la cantidad de postres vendidos, los ingresos totales, el índice del postre
     * actualmente seleccionado y la información del siguiente postre a mostrar.
     */
    fun onDessertClicked() {
        _uiState.update { cupcakeUiState ->
            val dessertsSold = cupcakeUiState.dessertsSold.inc()
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            cupcakeUiState.copy(
                currentDessertIndex = nextDessertIndex,
                dessertsSold = dessertsSold,
                revenue = cupcakeUiState.revenue + cupcakeUiState.currentDessertPrice,
                currentDessertImageId = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price

            )
        }
    }

    /**
     * Determina el índice del postre a mostrar basado en la cantidad de postres vendidos.
     *
     * Esta función toma la cantidad total de postres vendidos (`dessertsSold`) como entrada y
     * devuelve el índice del postre correspondiente que se debe mostrar en la interfaz de usuario.
     *
     * La lógica se basa en la lista ordenada de postres (`dessertList`) donde cada postre tiene una propiedad
     * `startProductionAmount` que indica la cantidad mínima de postres vendidos necesaria para comenzar
     * a producir ese postre.
     *
     * La función itera a través de la lista y compara la cantidad vendida (`dessertsSold`) con el
     * `startProductionAmount` de cada postre. Si la cantidad vendida es mayor o igual al
     * `startProductionAmount` del postre actual, el índice de ese postre se devuelve.
     * La iteración se detiene una vez que se encuentra un postre cuya cantidad de producción inicial es mayor
     * a la cantidad vendida, ya que la lista está ordenada.
     *
     * @param dessertsSold La cantidad total de postres vendidos.
     * @return El índice del postre que se debe mostrar en la interfaz de usuario.
     */
    fun determineDessertIndex(
        dessertsSold: Int
    ): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertIndex
    }

    /**
     * Share desserts sold information using ACTION_SEND intent
     */
    fun shareSoldDessertsInformation(intentContext: Context, dessertsSold: Int, revenue: Int) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT,
                intentContext.getString(R.string.share_text, dessertsSold, revenue)
            )
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)

        try {
            ContextCompat.startActivity(intentContext, shareIntent, null)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                intentContext,
                intentContext.getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}