package com.example.cursoandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
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
                    BusinessCardApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }


    @Composable
    fun BusinessCardApp(modifier: Modifier = Modifier) {
        Column(

            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InfoProfile()
            InfoContact()
        }
    }


    @Composable
    private fun InfoProfile() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagen_de_perfil_navarro_federico),
                contentDescription = "Foto de perfil por defecto",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
            )
            Text(
                text = "Navarro Federico",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Android Developer ",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF3ddc84)
            )


        }

    }

    @Composable
    fun InfoContact(modifier: Modifier = Modifier) {
        var scrollState = rememberScrollState()

        val typeIcon = Icons.Rounded
        val iconCall = typeIcon.Call
        val iconShare = typeIcon.Share
        val iconGitHub = painterResource(id = R.drawable.icon_github)
        val iconEmail = typeIcon.Email

        val urlGithub = "https://github.com/NavarroFederico"

        Column(Modifier.verticalScroll(scrollState)) {
            Item(iconCall, "+54 (11)23823504")
            Item(iconGitHub, "My GitHub")
        }

    }

    @Composable
    fun Item(icon: Any, info: String, modifier: Modifier = Modifier) {
        var scrollState = rememberScrollState()
        val uriHandler = LocalUriHandler.current

        Row (modifier.horizontalScroll(scrollState)){

            when (icon) {
                is ImageVector -> {
                    Icon(icon, contentDescription = null)
                    Spacer(Modifier.size(16.dp))
                    Text(text = info)
                }

                is Painter -> {
                    Icon(painter = icon, contentDescription = null, modifier = Modifier.size(28.dp))
                    Spacer(Modifier.size(16.dp))
                    ClickableText(
                        text = AnnotatedString(info),
                        onClick = { uriHandler.openUri("https://github.com/NavarroFederico") })
                }
            }
        }

    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        CursoAndroidComposeTheme {
            BusinessCardApp(Modifier.fillMaxSize())
        }

    }
}
