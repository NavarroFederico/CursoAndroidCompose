package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes
    var stringResourceId: Int,
    var numberOfAssociatedCurses: Int,
    @DrawableRes
    var drawableResourceId: Int,
)
