package com.example.patronesdedisenoapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

data class PatternDesign(
    val id: Int,
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
    val patternType: PatternType,
    @StringRes val url: Int,
    val colorType: Color = patternType.color

)
