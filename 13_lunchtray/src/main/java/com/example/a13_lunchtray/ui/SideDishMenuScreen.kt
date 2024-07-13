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
import com.example.a13_lunchtray.model.MenuItem.SideDishItem

/**
 * Composable para la pantalla del menú de acompañamientos.
 *
 * Esta función Composable extiende la funcionalidad de `BaseMenuScreen` para mostrar
 * específicamente un menú de acompañamientos. Se espera recibir una lista de objetos
 * `SideDishItem` que representan los acompañamientos disponibles.
 *
 * @param options Lista de objetos `SideDishItem` que representan los acompañamientos del menú (List<SideDishItem>).
 * @param onCancelButtonClicked Lambda que se invoca al hacer clic en el botón de cancelar ((): Unit).
 * @param onNextButtonClicked Lambda que se invoca al hacer clic en el botón de continuar ((): Unit).
 * @param onSelectionChanged Lambda que se invoca cuando se selecciona un acompañamiento ((SideDishItem) -> Unit).
 * @param modifier Modificador opcional para personalizar el estilo de la pantalla (Modifier - valor por defecto es Modifier).
 *
 * **Nota:** Esta función reutiliza la funcionalidad de `BaseMenuScreen` para la estructura base
 * de la pantalla del menú.
 */
@Composable
fun SideDishMenuScreen(
    options: List<SideDishItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (SideDishItem) -> Unit,
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

@Preview(showBackground = true)
@Composable
fun SideDishMenuPreview(){
    SideDishMenuScreen(
        options = DataSource.sideDishMenuItems,
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        onSelectionChanged = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
}
