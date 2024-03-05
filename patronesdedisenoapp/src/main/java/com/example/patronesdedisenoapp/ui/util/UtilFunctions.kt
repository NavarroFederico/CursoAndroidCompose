package com.example.patronesdedisenoapp.ui.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle

@Composable
fun customSpanStyle(style: TextStyle, color: Color? = null): SpanStyle {
    return SpanStyle(
        fontStyle = style.fontStyle,
        fontFamily = style.fontFamily,
        fontWeight = style.fontWeight,
        fontSize = style.fontSize,
        color = color ?: MaterialTheme.colorScheme.primary
    )
}