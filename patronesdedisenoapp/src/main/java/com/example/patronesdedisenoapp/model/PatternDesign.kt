package com.example.patronesdedisenoapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PatternDesign(
    val id: Int,
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
    val patternType: PatternType,
    val url: String = "",

)
