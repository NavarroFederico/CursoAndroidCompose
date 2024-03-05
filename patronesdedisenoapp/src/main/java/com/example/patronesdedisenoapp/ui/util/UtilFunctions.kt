package com.example.patronesdedisenoapp.ui.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle

fun customSpanStyle(style: TextStyle, color: Color? = null): SpanStyle {
    return SpanStyle(
        fontStyle = style.fontStyle,
        fontFamily = style.fontFamily,
        fontWeight = style.fontWeight,
        fontSize = style.fontSize,
        color = color ?: style.color
    )
}