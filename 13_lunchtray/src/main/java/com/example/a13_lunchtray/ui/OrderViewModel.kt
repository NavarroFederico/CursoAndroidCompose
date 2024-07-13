/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.a13_lunchtray.ui

import androidx.lifecycle.ViewModel
import com.example.a13_lunchtray.model.MenuItem
import com.example.a13_lunchtray.model.MenuItem.AccompanimentItem
import com.example.a13_lunchtray.model.MenuItem.EntreeItem
import com.example.a13_lunchtray.model.MenuItem.SideDishItem
import com.example.a13_lunchtray.model.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

/**
 * ViewModel para el manejo del estado de un pedido.
 *
 * Esta clase ViewModel proporciona un flujo de estado (`StateFlow`) llamado `uiState`
 * que representa el estado actual del pedido. El estado del pedido incluye información
 * como el plato principal, acompañamiento, precio total de los artículos, impuestos y
 * precio total final.
 *
 * La clase también provee métodos para actualizar el plato principal (`updateEntree`),
 * acompañamiento (`updateSideDish`), guarnición (`updateAccompaniment`) y reiniciar el
 * pedido (`resetOrder`).
 */
class OrderViewModel : ViewModel() {

    private val taxRate = 0.08

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    /**
     * Actualiza el plato principal del pedido.
     *
     * Este método actualiza el estado del pedido con el nuevo plato principal
     * recibido como parámetro. También recalcula el precio total de los artículos,
     * impuestos y precio total final considerando el precio anterior del plato principal
     * (si es que ya había uno seleccionado).
     *
     * @param entree Objeto `EntreeItem` que representa el nuevo plato principal (EntreeItem).
     */
    fun updateEntree(entree: EntreeItem) {
        val previousEntree = _uiState.value.entree
        updateItem(entree, previousEntree)
    }

    /**
     * Actualiza el acompañamiento del pedido.
     *
     * Este método actualiza el estado del pedido con el nuevo acompañamiento
     * recibido como parámetro. También recalcula el precio total de los artículos,
     * impuestos y precio total final considerando el precio anterior del acompañamiento
     * (si es que ya había uno seleccionado).
     *
     * @param sideDish Objeto `SideDishItem` que representa el nuevo acompañamiento (SideDishItem).
     */
    fun updateSideDish(sideDish: SideDishItem) {
        val previousSideDish = _uiState.value.sideDish
        updateItem(sideDish, previousSideDish)
    }

    /**
     * Actualiza la guarnición del pedido.
     *
     * Este método actualiza el estado del pedido con la nueva guarnición
     * recibida como parámetro. También recalcula el precio total de los artículos,
     * impuestos y precio total final considerando el precio anterior de la guarnición
     * (si es que ya había una seleccionada).
     *
     * @param accompaniment Objeto `AccompanimentItem` que representa la nueva guarnición (AccompanimentItem).
     */
    fun updateAccompaniment(accompaniment: AccompanimentItem) {
        val previousAccompaniment = _uiState.value.accompaniment
        updateItem(accompaniment, previousAccompaniment)
    }

    /**
     * Reinicia el estado del pedido a sus valores iniciales.
     *
     * Este método reinicia el flujo de estado `_uiState` a un nuevo objeto
     * `OrderUiState()` con valores por defecto (ningún elemento seleccionado,
     * precios a 0, etc.).
     */
    fun resetOrder() {
        _uiState.value = OrderUiState()
    }

    /**
     * Método privado utilizado para actualizar el estado del pedido con un nuevo elemento.
     *
     * Este método se utiliza internamente por `updateEntree`, `updateSideDish` y
     * `updateAccompaniment` para actualizar el estado del pedido con un nuevo elemento
     * de una categoría específica (plato principal, acompañamiento, guarnición).
     * Recalcula los precios totales y el impuesto en base al precio del nuevo elemento
     * y el precio anterior del elemento de la misma categoría (si existía).
     *
     * @param newItem Objeto `MenuItem` que representa el nuevo elemento a agregar (MenuItem).
     * @param previousItem Objeto `MenuItem` opcional que representa el elemento anterior de la misma categoría (MenuItem - null si no había ninguno).
     */
    private fun updateItem(newItem: MenuItem, previousItem: MenuItem?) {
        _uiState.update { currentState ->
            val previousItemPrice = previousItem?.price ?: 0.0
            // subtract previous item price in case an item of this category was already added.
            val itemTotalPrice = currentState.itemTotalPrice - previousItemPrice + newItem.price
            // recalculate tax
            val tax = itemTotalPrice * taxRate
            currentState.copy(
                itemTotalPrice = itemTotalPrice,
                orderTax = tax,
                orderTotalPrice = itemTotalPrice + tax,
                entree = if (newItem is EntreeItem) newItem else currentState.entree,
                sideDish = if (newItem is SideDishItem) newItem else currentState.sideDish,
                accompaniment =
                    if (newItem is AccompanimentItem) newItem else currentState.accompaniment
            )
        }
    }
}

/**
 * Formatea un valor decimal como precio con signo de moneda.
 *
 * Esta función de extensión convierte un valor decimal (por ejemplo, 15.5) a una cadena
 * de texto que representa el precio con el símbolo de moneda correspondiente a la localidad
 * del dispositivo (por ejemplo, "$15.50").
 *
 * @return String La cadena de texto formateada como precio con signo de moneda.
 */
fun Double.formatPrice(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}
