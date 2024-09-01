/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.a22_inventoryapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a22_inventoryapp.data.Item
import com.example.a22_inventoryapp.data.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


/**
 * ViewModel to retrieve all items in the Room database.
 */
class HomeViewModel(itemsRepository: ItemsRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    /**
     * La forma recomendada de exponer un Flow desde un ViewModel es con un StateFlow. El uso de un StateFlow permite guardar y observar los datos, sin importar el ciclo de vida de la IU. Para convertir un Flow en un StateFlow, usa el operador stateIn.
     *
     * El operador stateIn tiene tres parámetros que se explican a continuación:
     *
     * scope: El viewModelScope define el ciclo de vida del StateFlow. Cuando se cancela el viewModelScope, también se cancela el StateFlow.
     * started: La canalización solo debe estar activa cuando la IU sea visible. Se usa SharingStarted.WhileSubscribed() para lograr esto. Para configurar una demora (en milisegundos) entre la desaparición del último suscriptor y la detención de la corrutina de uso compartido, pasa TIMEOUT_MILLIS al método SharingStarted.WhileSubscribed().
     * initialValue: Establece el valor inicial del flujo de estado en HomeUiState().
     */
    val homeUiState: StateFlow<HomeUiState> =
        itemsRepository.getAllItemsStream().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()

            )
}

/**
 * Ui State for HomeScreen
 */
data class HomeUiState(val itemList: List<Item> = listOf())
