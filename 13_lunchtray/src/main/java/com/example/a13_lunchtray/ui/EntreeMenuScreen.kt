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

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a13_lunchtray.R
import com.example.a13_lunchtray.datasource.DataSource
import com.example.a13_lunchtray.model.MenuItem
import com.example.a13_lunchtray.model.MenuItem.EntreeItem

/**
 * Composable para la pantalla del menú de platos principales.
 *
 * Esta función Composable extiende la funcionalidad de `BaseMenuScreen` para mostrar
 * específicamente un menú de platos principales. Se espera recibir una lista de objetos
 * `EntreeItem` que representan los platos disponibles.
 *
 * @param options Lista de objetos `EntreeItem` que representan los platos principales del menú (List<EntreeItem>).
 * @param onCancelButtonClicked Lambda que se invoca al hacer clic en el botón de cancelar ((): Unit).
 * @param onNextButtonClicked Lambda que se invoca al hacer clic en el botón de continuar ((): Unit).
 * @param onSelectionChanged Lambda que se invoca cuando se selecciona un plato principal ((EntreeItem) -> Unit).
 * @param modifier Modificador opcional para personalizar el estilo de la pantalla (Modifier - valor por defecto es Modifier).
 *
 * **Nota:** Esta función reutiliza la funcionalidad de `BaseMenuScreen` para la estructura base
 * de la pantalla del menú.
 */
@Composable
fun EntreeMenuScreen(
    options: List<EntreeItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (EntreeItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        modifier = modifier
    )
}

/**
 * Composable de previsualización para la pantalla del menú de platos principales.
 *
 * Esta función Composable se utiliza con la anotación `@Preview` para previsualizar
 * la pantalla del menú de platos principales en Android Studio.
 *
 * @param options Lista de objetos `EntreeItem` que representan los platos principales del menú (List<EntreeItem>). (Valor por defecto: `DataSource.entreeMenuItems`)
 * @param onCancelButtonClicked Lambda que se invoca al hacer clic en el botón de cancelar ((): Unit). (Valor por defecto: función vacía)
 * @param onNextButtonClicked Lambda que se invoca al hacer clic en el botón de continuar ((): Unit). (Valor por defecto: función vacía)
 * @param onSelectionChanged Lambda que se invoca cuando se selecciona un plato principal ((EntreeItem) -> Unit). (Valor por defecto: función vacía)
 * @param modifier Modificador opcional para personalizar el estilo de la previsualización (Modifier - valor por defecto agrega padding y scroll vertical).
 *
 * **Importante:** Esta función está destinada únicamente para previsualizar la pantalla del menú
 * y no se utiliza en la aplicación real.
 */
@Preview(showBackground = true)
@Composable
fun EntreeMenuPreview(){
    EntreeMenuScreen(
        options = DataSource.entreeMenuItems,
        onCancelButtonClicked = {},
        onNextButtonClicked = {},
        onSelectionChanged = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
}
