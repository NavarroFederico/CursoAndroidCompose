package com.example.cursoandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursoandroidcompose.ui.theme.CursoAndroidComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoAndroidComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    InstructionalScreen()
                }
            }
        }
    }
}

@Composable
fun InstructionalScreen(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(painter = image, contentDescription = null, modifier = Modifier.fillMaxWidth())
        TextBody()
    }

}

@Composable
fun TextBody(modifier: Modifier = Modifier) {
    Text(text = stringResource(R.string.jetpack_compose_tutorial), modifier = modifier.padding(16.dp), fontSize = 24.sp)
    Text(text = stringResource(R.string.content_text),Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    Text(text = stringResource(R.string.content_text2),Modifier.padding(16.dp), textAlign = TextAlign.Justify )
}

@Preview(showBackground = true, device = "id:Nexus 5")
@Composable
fun GreetingPreview() {
    CursoAndroidComposeTheme {
        InstructionalScreen()
    }
}