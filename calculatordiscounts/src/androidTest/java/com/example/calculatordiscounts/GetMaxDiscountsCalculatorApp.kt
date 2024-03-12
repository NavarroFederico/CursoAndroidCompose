package com.example.calculatordiscounts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.cursoandroidcompose.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class GetMaxDiscountsCalculatorAppIUTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculateMaxPurchaseAmount_3000DiscountLimit_And_20PercentDiscount() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TipTimeLayout()
                }
            }
        }
        composeTestRule.onNodeWithText("Discount Limit").performTextInput("3000")
        composeTestRule.onNodeWithText("Discount percent").performTextInput("20")

        val expectedPurchaseAmount = NumberFormat.getCurrencyInstance().format(15000)
        composeTestRule.onNodeWithText("Maximum purchase amount: $expectedPurchaseAmount")
            .assertExists("No node with this text was found.")
    }

    @Test
    fun calculateMaxPurchaseAmount_3000DiscountLimit_And_20PercentDiscountInSpanish() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TipTimeLayout()
                }
            }
        }
        composeTestRule.onNodeWithText("Tope de descuento").performTextInput("3000")
        composeTestRule.onNodeWithText("Porcentaje de descuento").performTextInput("20")

        val expectedPurchaseAmount = NumberFormat.getCurrencyInstance().format(15000)
        composeTestRule.onNodeWithText("Gasta un total de $expectedPurchaseAmount")
            .assertExists("No node with this text was found.")
    }
}