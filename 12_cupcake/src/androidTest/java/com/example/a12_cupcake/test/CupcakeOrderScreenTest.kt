package com.example.a12_cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.a12_cupcake.R
import com.example.a12_cupcake.data.OrderUiState
import com.example.a12_cupcake.ui.OrderSummaryScreen
import com.example.a12_cupcake.ui.SelectOptionScreen
import com.example.a12_cupcake.ui.StartOrderScreen
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest() {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val fakeOrderUiState = OrderUiState(
        quantity = 6,
        flavor = "Vanilla",
        date = "Wed Jul 21",
        price = "$100",
        pickupOptions = listOf()
    )

    @Test
    fun selectOptionScreen_verifyContent() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // And subtotal
        val subtotal = "$100"

        // When SelectOptionScreen is loaded
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }
        // Then all the options are displayed on the screen.
        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }
        // And then the subtotal is displayed correctly.
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                subtotal
            )
        ).assertIsDisplayed()

        // And then the next button is disabled
        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
    }

    /**
     * Verifica el contenido de Start screen
     */
    @Test
    fun startOrderScreen_verifyContent() {
        //Given list of options
        val quantityOptions = listOf(
            Pair(R.string.one_cupcake, 1),
            Pair(R.string.six_cupcakes, 6),
            Pair(R.string.twelve_cupcakes, 12)
        )
        //When StartScreen is loaded
        composeTestRule.setContent {
            StartOrderScreen(quantityOptions = quantityOptions, onNextButtonClicked = {})
        }
        // Then all the options are displayed on the screen.
        quantityOptions.forEach { quantity ->
            composeTestRule.onNodeWithStringId(quantity.first).assertIsDisplayed()
        }
    }

    /**
     * verifica el contenido de Summary screen
     * When a OrderUiState is provided to Summary Screen, then the flavor, date and subtotal is
     * displayed on the screen.
     */


    @Test
    fun summaryScreen_verifyContentDisplay() {
        // When Summary Screen is loaded
        composeTestRule.setContent {
            OrderSummaryScreen(
                orderUiState = fakeOrderUiState,
                onCancelButtonClicked = {},
                onSendButtonClicked = { _, _ -> },
            )
        }

        // Then the UI is updated correctly.
        composeTestRule.onNodeWithText(fakeOrderUiState.flavor).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeOrderUiState.date).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                fakeOrderUiState.price
            )
        ).assertIsDisplayed()
    }


    /**
     * Verifica que el boton Next esté habilitado cuando se seleccione una opción en la pantalla de selección de sabores
     */
    @Test
    fun selectOptionScreen_optionSelect_NextButtonEnabled() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // And subtotal
        val subtotal = "$100"

        // When SelectOptionScreen is loaded
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }
        // Then options chocolate selected on the screen.
        composeTestRule.onNodeWithStringId(R.string.chocolate)
            .performClick()
        // And then the next button is enabled
        composeTestRule.onNodeWithStringId(R.string.next).assertIsEnabled()

    }
}