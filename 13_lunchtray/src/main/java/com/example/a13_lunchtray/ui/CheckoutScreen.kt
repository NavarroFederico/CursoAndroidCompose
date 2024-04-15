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

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.a13_lunchtray.R
import com.example.a13_lunchtray.datasource.DataSource
import com.example.a13_lunchtray.model.MenuItem
import com.example.a13_lunchtray.model.OrderUiState

/**
 * Composable para la pantalla de resumen del pedido y pago.
 *
 * Esta función Composable muestra el resumen del pedido del usuario, incluyendo el plato principal,
 * acompañamientos, subtotal, impuestos y total final. También presenta botones para cancelar
 * o enviar el pedido.
 *
 * @param orderUiState Objeto `OrderUiState` que contiene información del pedido (OrderUiState).
 * @param onNextButtonClicked Lambda que se invoca al hacer clic en el botón de enviar pedido ((): Unit).
 * @param onCancelButtonClicked Lambda que se invoca al hacer clic en el botón de cancelar ((): Unit).
 * @param modifier Modificador opcional para personalizar el estilo de la pantalla (Modifier - valor por defecto es Modifier).
 *
 */
@Composable
fun CheckoutScreen(
    orderUiState: OrderUiState,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        Text(
            text = stringResource(R.string.order_summary),
            fontWeight = FontWeight.Bold
        )
        ItemSummary(item = orderUiState.entree, modifier = Modifier.fillMaxWidth())
        ItemSummary(item = orderUiState.sideDish, modifier = Modifier.fillMaxWidth())
        ItemSummary(item = orderUiState.accompaniment, modifier = Modifier.fillMaxWidth())

        Divider(
            thickness = dimensionResource(R.dimen.thickness_divider),
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small))
        )

        OrderSubCost(
            resourceId = R.string.subtotal,
            price = orderUiState.itemTotalPrice.formatPrice(),
            Modifier.align(Alignment.End)
        )

        OrderSubCost(
            resourceId = R.string.tax,
            price = orderUiState.orderTax.formatPrice(),
            Modifier.align(Alignment.End)
        )

        Text(
            text = stringResource(R.string.total, orderUiState.orderTotalPrice.formatPrice()),
            modifier = Modifier.align(Alignment.End),
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
        ){
            OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
                Text(stringResource(R.string.cancel).uppercase())
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.submit).uppercase())
            }
        }
    }
}

/**
 * Composable para mostrar un resumen de un elemento del pedido.
 *
 * Esta función Composable muestra el nombre y precio formateado de un elemento del pedido
 * (plato principal, acompañamiento, etc.) recibido como parámetro.
 *
 * @param item Objeto `MenuItem` opcional que representa el elemento del pedido (MenuItem?).
 * @param modifier Modificador opcional para personalizar el estilo del resumen (Modifier - valor por defecto es Modifier).
 */
@Composable
fun ItemSummary(
    item: MenuItem?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(item?.name ?: "")
        Text(item?.getFormattedPrice() ?: "")
    }
}

/**
 * Composable para mostrar un subcosto del pedido (subtotal, impuestos, etc.).
 *
 * Esta función Composable muestra un texto que combina un recurso de string
 * (por ejemplo, "Subtotal") con el precio formateado recibido como parámetro.
 *
 * @param resourceId Identificador de recurso de string que representa el subcosto (int - @StringRes).
 * @param price Precio formateado del subcosto como cadena de texto (String).
 * @param modifier Modificador opcional para personalizar el estilo del subcosto (Modifier - valor por defecto es Modifier).
 *
 */
@Composable
fun OrderSubCost(
    @StringRes resourceId: Int,
    price: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(resourceId, price),
        modifier = modifier
    )
}

/**
 * Composable de previsualización para la pantalla de resumen del pedido y pago.
 *
 * Esta función Composable se utiliza con la anotación `@Preview` para previsualizar
 * la pantalla de resumen del pedido y pago en Android Studio. Se proporciona un objeto
 * `OrderUiState` de ejemplo con valores predeterminados.
 *
 * @param orderUiState Objeto `OrderUiState` predefinido con información del pedido para la previsualización
 * (valores por defecto: `entree = DataSource.entreeMenuItems[0]`,
 * `sideDish = DataSource.sideDishMenuItems[0]`,
 * `accompaniment = DataSource.accompanimentMenuItems[0]`,
 * `itemTotalPrice = 15.00`,
 * `orderTax = 1.00`,
 * `orderTotalPrice = 16.00`).
 *
 * **Importante:** Esta función está destinada únicamente para previsualizar la pantalla del pedido
 * y no se utiliza en la aplicación real.
 */
@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen(
        orderUiState = OrderUiState(
            entree = DataSource.entreeMenuItems[0],
            sideDish = DataSource.sideDishMenuItems[0],
            accompaniment = DataSource.accompanimentMenuItems[0],
            itemTotalPrice = 15.00,
            orderTax = 1.00,
            orderTotalPrice = 16.00
        ),
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
}
