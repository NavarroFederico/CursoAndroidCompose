package com.example.a16_mycity.model

import androidx.compose.ui.graphics.Color

enum class CategoryType(val color: Color) {
    Parks(
        color = Color.Green
    ),
    ShoppingCenters(
        color = Color.Magenta
    ),
    Housing(
        color = Color.Blue
    ),
    GovernmentOffices(
        color = Color.LightGray
    )
}
