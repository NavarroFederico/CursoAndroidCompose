package com.example.a10_dessertclicker.ui

import androidx.annotation.DrawableRes
import com.example.a10_dessertclicker.data.Datasource.dessertList

data class DessertClickerUIState(
    val currentDessertIndex: Int = 0,
    val dessertsSold: Int = 0,
    var revenue: Int = 0,
    var currentDessertPrice: Int = dessertList[currentDessertIndex].price,
    @DrawableRes var currentDessertImageId: Int = dessertList[currentDessertIndex].imageId,

    ) {
}