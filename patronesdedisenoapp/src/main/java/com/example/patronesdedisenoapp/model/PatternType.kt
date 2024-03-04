package com.example.patronesdedisenoapp.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.example.patronesdedisenoapp.ui.theme.TypePatternBehavioral
import com.example.patronesdedisenoapp.ui.theme.TypePatternCreational
import com.example.patronesdedisenoapp.ui.theme.TypePatternStructural


enum class PatternType(val color: Color) {
    CREATIONAL(color = TypePatternCreational), STRUCTURAL(color = TypePatternStructural), BEHAVIORAL(
        color = TypePatternBehavioral
    )
}