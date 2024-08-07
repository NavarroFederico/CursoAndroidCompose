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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a13_lunchtray.R

/**
 * Composable para la pantalla inicial para iniciar un pedido.
 *
 * Esta función Composable muestra un botón centralizado que permite al usuario iniciar
 * un nuevo pedido. Al hacer clic en el botón, se invoca la lambda `onStartOrderButtonClicked`.
 *
 * @param onStartOrderButtonClicked Lambda que se invoca al hacer clic en el botón para iniciar un pedido ((): Unit).
 * @param modifier Modificador opcional para personalizar el estilo de la pantalla (Modifier - valor por defecto es Modifier).
 *
 */
@Composable
fun StartOrderScreen(
    onStartOrderButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onStartOrderButtonClicked,
            Modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(R.string.start_order))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartOrderPreview(){
    StartOrderScreen(
        onStartOrderButtonClicked = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize()
    )
}
