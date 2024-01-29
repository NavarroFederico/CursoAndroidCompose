package com.example.cursoandroidcompose

import org.junit.Assert.assertEquals
import org.junit.Test

class GetMaxDiscountsCalculatorAppTest {

    @Test
    fun calculateMaxPurchaseAmount_3000DiscountLimit_And_20PercentDiscount() {
        val discountLimit = 3000.00
        val discountPercent = 20.00
        val expectedPurchaseAmount = 15000.00
        val actualPurchaseAmount = calculatePurchaseLimit(discountLimit, discountPercent)
        assertEquals(expectedPurchaseAmount, actualPurchaseAmount, 0.001)
    }

    @Test
    fun calculateFinalCost_15000PurchaseAmount_minus_3000DiscountLimit() {
        val purchaseLimit = 15000.00
        val discountLimit = 3000.00
        val expectedFinalCost = 12000.00
        val actualFinalCost = calculateCostFinal(purchaseLimit, discountLimit)
        assertEquals(expectedFinalCost, actualFinalCost, 0.001)

    }
}