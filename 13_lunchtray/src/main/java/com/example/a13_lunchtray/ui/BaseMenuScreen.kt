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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a13_lunchtray.R
import com.example.a13_lunchtray.datasource.DataSource
import com.example.a13_lunchtray.model.MenuItem

/**
 * Composable para la pantalla base del menú.
 *
 * Esta función Composable crea la estructura base para una pantalla de selección de elementos de un menú.
 *
 * @param options Lista de objetos `MenuItem` que representan las opciones del menú (List<MenuItem>).
 * @param modifier Modificador opcional para personalizar el estilo de la pantalla (Modifier - valor por defecto es Modifier).
 * @param onCancelButtonClicked Lambda que se invoca al hacer clic en el botón de cancelar ((): Unit - valor por defecto es una función vacía).
 * @param onNextButtonClicked Lambda que se invoca al hacer clic en el botón de continuar ((): Unit - valor por defecto es una función vacía).
 * @param onSelectionChanged Lambda que se invoca cuando se selecciona un elemento del menú ((MenuItem) -> Unit).
 *
 * @Composable
 * Esta función es declarada como Composable, lo que significa que puede ser utilizada para construir
 * la interfaz de usuario de forma declarativa.
 */
@Composable
fun BaseMenuScreen(
    options: List<MenuItem>,
    modifier: Modifier = Modifier,
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    onSelectionChanged: (MenuItem) -> Unit,
) {

    var selectedItemName by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier) {
        options.forEach { item ->
            val onClick = {
                selectedItemName = item.name
                onSelectionChanged(item)
            }
            MenuItemRow(
                item = item,
                selectedItemName = selectedItemName,
                onClick = onClick,
                modifier = Modifier.selectable(
                    selected = selectedItemName == item.name,
                    onClick = onClick
                )
            )
        }

        MenuScreenButtonGroup(
            selectedItemName = selectedItemName,
            onCancelButtonClicked = onCancelButtonClicked,
            onNextButtonClicked = {
                // Assert not null bc next button is not enabled unless selectedItem is not null.
                onNextButtonClicked()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}

/**
 * Composable para una fila de un elemento del menú.
 *
 * Esta función Composable representa una fila de un elemento del menú con su nombre,
 * descripción, precio formateado y un botón de radio para selección.
 *
 * @param item Objeto `MenuItem` que representa el elemento del menú (MenuItem).
 * @param selectedItemName Nombre del elemento actualmente seleccionado (String).
 * @param onClick Lambda que se invoca al hacer clic en la fila del elemento ((: ) -> Unit).
 * @param modifier Modificador opcional para personalizar el estilo de la fila (Modifier - valor por defecto es Modifier).
 */
@Composable
fun MenuItemRow(
    item: MenuItem,
    selectedItemName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedItemName == item.name,
            onClick = onClick
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = item.getFormattedPrice(),
                style = MaterialTheme.typography.bodyMedium
            )
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

/**
 * Composable para el grupo de botones de la pantalla del menú (cancelar y continuar).
 *
 * Esta función Composable crea el grupo de botones ubicados en la parte inferior
 * de la pantalla del menú, con botones para cancelar y continuar. El botón de
 * continuar se habilita solo cuando se ha seleccionado un elemento del menú.
 *
 * @param selectedItemName Nombre del elemento actualmente seleccionado (String).
 * @param onCancelButtonClicked Lambda que se invoca al hacer clic en el botón de cancelar ((): Unit).
 * @param onNextButtonClicked Lambda que se invoca al hacer clic en el botón de continuar ((): Unit).
 * @param modifier Modificador opcional para personalizar el estilo del grupo de botones (Modifier - valor por defecto es Modifier).
 */
@Composable
fun MenuScreenButtonGroup(
    selectedItemName: String,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
    ){
        OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
            Text(stringResource(R.string.cancel).uppercase())
        }
        Button(
            modifier = Modifier.weight(1f),
            // the button is enabled when the user makes a selection
            enabled = selectedItemName.isNotEmpty(),
            onClick = onNextButtonClicked
        ) {
            Text(stringResource(R.string.next).uppercase())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BaseMenuPreview() {
    BaseMenuScreen(
        options = DataSource.entreeMenuItems,
        onCancelButtonClicked = {},
        onNextButtonClicked = {},
        onSelectionChanged = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
}