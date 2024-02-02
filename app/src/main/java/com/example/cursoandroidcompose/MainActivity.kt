package com.example.cursoandroidcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

    var imageNum by remember { mutableStateOf(1) }


    when (imageNum) {
        1 -> {
            ArtSpaceWallDescriptorDisplayController(
                imageResource = R.drawable.camioneta_roja,
                titleArtwork = R.string.red_truck_by_the_post,
                descriptionArtwork = R.string.red_truck_description,
                onStartClickedNext = { imageNum++ },
                onStartClickedPreviuos = { imageNum = 4 }
            )
        }

        2 -> {
            ArtSpaceWallDescriptorDisplayController(
                imageResource = R.drawable.chevrolet_blanco_y_negro,
                titleArtwork = R.string.autumn_landscape,
                descriptionArtwork = R.string.autumn_landscape_description,
                onStartClickedNext = { imageNum++ },
                onStartClickedPreviuos = { imageNum-- }
            )
        }

        3 -> {
            ArtSpaceWallDescriptorDisplayController(
                imageResource = R.drawable.auto_deportivo_blanco_y_negro,
                titleArtwork = R.string.sportiness_in_motion,
                descriptionArtwork = R.string.sportiness_description,
                onStartClickedNext = { imageNum++ },
                onStartClickedPreviuos = { imageNum-- }
            )
        }

        4 -> {
            ArtSpaceWallDescriptorDisplayController(
                imageResource = R.drawable.guerrero_bohemio,
                titleArtwork = R.string.the_bohemian_warrior,
                descriptionArtwork = R.string.the_bohemian_warrior_description,
                onStartClickedNext = { imageNum = 1 },
                onStartClickedPreviuos = { imageNum-- }
            )
        }
    }
}

@Composable
fun ArtSpaceWallDescriptorDisplayController(
    @DrawableRes imageResource: Int,
    @StringRes titleArtwork: Int,
    @StringRes descriptionArtwork: Int,
    onStartClickedNext: () -> Unit,
    onStartClickedPreviuos: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isImageExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ArtworkWall(
            imageResource = imageResource,
            isImageExpanded = isImageExpanded,
            onStartClicked = { isImageExpanded = !isImageExpanded },
            modifier = Modifier.weight(2f),

            )
        Spacer(modifier = Modifier.height(32.dp))
        ArtworkDescriptor(
            titleArtwork = titleArtwork,
            descriptionArtwork = descriptionArtwork, modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        DisplayController(
            onStartClickedPreviuos = onStartClickedPreviuos,
            onStartClickedNext = onStartClickedNext,
            modifier = Modifier.weight(1f)
        )
    }

}

@Composable
fun ArtworkWall(
    @DrawableRes imageResource: Int,
    isImageExpanded: Boolean,
    onStartClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 16.dp,
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onStartClicked),
        color = Color.White
    ) {
        Image(
            modifier = modifier
                .padding(32.dp),
            painter = painterResource(id = imageResource),
            contentDescription = null
        )
    }
    if (isImageExpanded) {
        FullscreenImage(imageResource = imageResource, onStartClicked = { onStartClicked.invoke() })
    }
}

@Composable
fun FullscreenImage(
    @DrawableRes imageResource: Int,
    onStartClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .clickable(onClick = onStartClicked)
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Inside
        )
    }
}

@Composable
fun ArtworkDescriptor(
    @StringRes titleArtwork: Int,
    @StringRes descriptionArtwork: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Bottom) {
        Surface(
            color = Color.LightGray, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = titleArtwork),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 12.dp)
                )
                Text(
                    text = stringResource(id = descriptionArtwork),
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun DisplayController(
    onStartClickedPreviuos: () -> Unit,
    onStartClickedNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Button(onClick = {
            onStartClickedPreviuos.invoke()
            Log.d("", "hice click previous")
        }, Modifier.weight(1f)) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.width(32.dp))
        Button(onClick = {
            onStartClickedNext.invoke()
            Log.d("", "hice click next")
        }, Modifier.weight(1f)) {
            Text(text = "Next")

        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}