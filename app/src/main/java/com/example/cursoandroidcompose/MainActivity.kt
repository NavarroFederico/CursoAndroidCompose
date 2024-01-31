package com.example.cursoandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursoandroidcompose.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ArtworkWall(modifier = Modifier.weight(2f))
        Spacer(modifier = Modifier.height(32.dp))
        ArtworkDescriptor(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.height(16.dp))
        DisplayController(modifier = Modifier.weight(1f))
    }
}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Button(onClick = { /*TODO*/ }, Modifier.weight(1f)) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.width(32.dp))
        Button(onClick = { /*TODO*/ }, Modifier.weight(1f)) {
            Text(text = "Next")

        }
    }
}

@Composable
fun ArtworkDescriptor(modifier: Modifier = Modifier) {
    Surface(color = Color.LightGray, modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "Artwork Title",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 12.dp)
            )
            Text(
                text = "Artwork Artist (Year) ",
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun ArtworkWall(modifier: Modifier = Modifier) {
    Surface(
        shadowElevation = 16.dp,
        modifier = modifier
            .fillMaxWidth(),
        color = Color.White
    ) {
        Image(
            modifier = modifier
                .padding(32.dp),
            /*contentScale = ContentScale.Crop,*/
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}