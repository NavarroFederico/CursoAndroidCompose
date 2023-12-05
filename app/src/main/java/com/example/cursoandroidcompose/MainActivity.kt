package com.example.cursoandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursoandroidcompose.ui.theme.CursoAndroidComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoAndroidComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun QuadrantScreen(name: String, modifier: Modifier = Modifier) {
    Row (){
        Quadrant(
            stringResource(id = R.string.first_title),
            stringResource(id = R.string.first_description),
        )
        Quadrant(
            stringResource(id = R.string.second_title),
            stringResource(id = R.string.second_description),
        )
    }
    Row {
        Quadrant(
            stringResource(id = R.string.third_title),
            stringResource(id = R.string.third_description),
        )
        Quadrant(
            stringResource(id = R.string.fourth_title),
            stringResource(id = R.string.fourth_description),
        )
    }

}

@Composable
fun Quadrant(title: String, content: String, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp)

    ) {
        Text(text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)
        Text(text = content, textAlign = TextAlign.Justify)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CursoAndroidComposeTheme {
        Quadrant(stringResource(id = R.string.first_title),stringResource(id = R.string.first_description), )
    }
}