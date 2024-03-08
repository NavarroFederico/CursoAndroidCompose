package com.example.patronesdedisenoapp.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.patronesdedisenoapp.R
import com.example.patronesdedisenoapp.ui.theme.TypePatternBehavioral
import com.example.patronesdedisenoapp.ui.theme.TypePatternCreational
import com.example.patronesdedisenoapp.ui.theme.TypePatternStructural


enum class PatternType(@StringRes val idStringRes: Int, val color: Color) {
    CREATIONAL(
        idStringRes = R.string.type_creational,
        color = TypePatternCreational
    ),
    STRUCTURAL(
        idStringRes = R.string.type_structural,
        color = TypePatternStructural
    ),
    BEHAVIORAL(
        idStringRes = R.string.type_behaviorial,
        color = TypePatternBehavioral
    )
}