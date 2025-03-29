package com.example.a22_appdescuento.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a22_appdescuento.R
import com.example.a22_appdescuento.ui.theme.AppTheme

@Composable
fun CalculatorEntryScreen() {
    /*val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
        }
    )*/
}

@Composable
fun CalculatorEntryBody(
    calculatorUiState: CalculatorUiState,
    onItemValueChange: (CalculationDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        CalculatorInputForm(
            calculationDetails = calculatorUiState.calculationsDetails,
            onValueChange = onItemValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            enabled = calculatorUiState.isEntryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.save_calculation))
        }
    }
}

@Composable
fun CalculatorInputForm(
    calculationDetails: CalculationDetails,
    modifier: Modifier = Modifier,
    onValueChange: (CalculationDetails) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        PurchasePriceInput(
            calculationDetails = calculationDetails,
            onValueChange = onValueChange,
            enabled = enabled,
        )
    }
}

@Composable
fun PurchasePriceInput(
    calculationDetails: CalculationDetails,
    onValueChange: (CalculationDetails) -> Unit = {},
    enabled: Boolean = true,
) {
    //TextField para el precio de compra del producto
    OutlinedTextField(
        value = calculationDetails.purchasePrice,
        onValueChange = { onValueChange(calculationDetails.copy(purchasePrice = it)) },
        label = { Text(stringResource(R.string.purchase_price_req)) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        modifier = Modifier.fillMaxWidth(),
        enabled = enabled,
        singleLine = true

    )
}


@Preview(showBackground = true)
@Composable
private fun CalculatorEntryScreenPreview() {
    AppTheme {
        CalculatorEntryBody(
            calculatorUiState = CalculatorUiState(
                calculationsDetails = CalculationDetails(
                    purchasePrice = "17000",
                    discountInPercent = "10",
                    discountInPesos = "1000",
                )
            ),
            onItemValueChange = {},
            onSaveClick = { /*TODO*/ })
    }
}