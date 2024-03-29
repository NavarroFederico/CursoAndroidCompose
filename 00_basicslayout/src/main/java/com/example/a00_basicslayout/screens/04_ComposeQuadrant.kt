package com.example.a00_basicslayout.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.example.a00_basicslayout.R
import com.example.a00_basicslayout.ui.theme.CursoAndroidComposeTheme


@Composable
fun ComposeQuadrantScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.weight(1f)) {
            QuadrantInfoCard(
                title = stringResource(id = R.string.first_title),
                content = stringResource(id = R.string.first_description),
                modifier = Modifier.weight(1f),
                background = Color(0xFFEADDFF)
            )
            QuadrantInfoCard(
                title = stringResource(id = R.string.second_title),
                content = stringResource(id = R.string.second_description),
                modifier = Modifier.weight(1f),
                background = Color(0xFFD0BCFF)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            QuadrantInfoCard(
                title = stringResource(id = R.string.third_title),
                content = stringResource(id = R.string.third_description),
                modifier = Modifier.weight(1f),
                background = Color(0xFFD0BCFF)
            )
            QuadrantInfoCard(
                title = stringResource(id = R.string.fourth_title),
                content = stringResource(id = R.string.fourth_description),
                modifier = Modifier.weight(1f),
                background = Color(0xFFF6EDFF)

            )
        }
    }

}

@Composable
fun QuadrantInfoCard(
    title: String,
    content: String,
    background: Color,
    modifier: Modifier = Modifier
) {
    Column(

        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(background)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(text = content, textAlign = TextAlign.Justify)
    }

}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    CursoAndroidComposeTheme {
        ComposeQuadrantScreen()

    }
}
