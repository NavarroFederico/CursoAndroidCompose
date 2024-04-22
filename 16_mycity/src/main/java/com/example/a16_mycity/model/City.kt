package com.example.a16_mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Recommendation (
    val id : Int,
    @StringRes val titleResourceId : Int,
    @StringRes val descriptionResourceId : Int,
    @StringRes val address : Int,
    @StringRes val openingHours : Int,
    @DrawableRes val imageResourceId : Int,
    val category : CategoryType,





    )
