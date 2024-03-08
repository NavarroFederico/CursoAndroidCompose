package com.example.patronesdedisenoapp.ui.util

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.example.patronesdedisenoapp.R

fun customSpanStyle(style: TextStyle, color: Color = style.color): SpanStyle {
    return SpanStyle(
        fontStyle = style.fontStyle,
        fontFamily = style.fontFamily,
        fontWeight = style.fontWeight,
        fontSize = style.fontSize,
        color = color
    )
}

/**
 * This composable function creates a clickable text element with an annotation for a URL.
 *
 * @param urlLink: An integer resource ID referencing the string containing the URL to link to.
 **/
@Composable
fun AnnotatedClickableText(urlLink: Int, style: TextStyle) {
    val annotatedText = buildAnnotatedString {
        withStyle(style = customSpanStyle(style = style)) {
            append(stringResource(R.string.para_m_s_info_click))
        }
        //This function call adds an annotation with the specified tag ("URL") and value (the URL string from the resource ID) to the annotatedText
        pushStringAnnotation(
            tag = "URL", annotation = stringResource(id = urlLink)
        )
        withStyle(style = customSpanStyle(style = style, color = Color.Blue)) {
            append(stringResource(R.string.aqui))
        }
        pop()
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(text = annotatedText, onClick = { offset ->
        // We check if there is an *URL* annotation attached to the text
        // at the clicked position
        annotatedText.getStringAnnotations(
            tag = "URL", start = offset, end = offset
        ).firstOrNull()?.let { annotation ->
            // If yes, we log its value
            uriHandler.openUri(annotation.item)
            Log.d("Clicked URL", annotation.item)
        }
    })

}