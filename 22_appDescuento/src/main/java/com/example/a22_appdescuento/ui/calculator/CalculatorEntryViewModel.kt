package com.example.a22_appdescuento.ui.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * ViewModel to validate and insert items in the Room database.
 */
class CalculatorEntryViewModel() : ViewModel() {

    /**
     * Holds current item ui state
     */
    var calculatorUiState by mutableStateOf(CalculatorUiState())
        private set

    /**
     * Updates  the [calculatorUiState] with the value provided in the argument.
     * This method also triggers a validation for input values.
     */
    fun updateUiState(calculationsDetails: CalculationDetails) {
        calculatorUiState =
            CalculatorUiState(
                calculationsDetails = calculationsDetails,
                isEntryValid = validateInput(calculationsDetails)
            )
    }

    private fun validateInput(uiState: CalculationDetails = calculatorUiState.calculationsDetails): Boolean {
        return with(uiState) {
            purchasePrice.isNotBlank() && discountInPercent.isNotBlank() && discountInPesos.isNotBlank()
        }
    }

    suspend fun saveCalculation() {
        TODO("Crear funcion para guardar calculos en el repositorio")
    }
}

/**
 * Represents Ui State for an Item.
 */
data class CalculatorUiState(
    val calculationsDetails: CalculationDetails = CalculationDetails(),
    val isEntryValid: Boolean = false
)

data class CalculationDetails(
    val id: Int = 0,
    val purchasePrice: String = "",
    val discountInPercent: String = "",
    val discountInPesos: String = "",
    val maximumDiscountInPesos: String = "",
    val maxPurchaseLimitPrice: String = "",
    val finalPrice: String = "",
)
