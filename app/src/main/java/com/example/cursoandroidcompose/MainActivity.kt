package com.example.cursoandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
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

                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }


    @Composable
    fun BusinessCardApp() {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InfoProfile()
            InfoContact()
        }
    }

    private @Composable
    fun InfoContact() {
        Column {


        }

    }

    private @Composable
    fun InfoProfile() {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagen_de_perfil_navarro_federico),
                contentDescription = "Foto de perfil por defecto",
                modifier = Modifier
                    .scale(4.0f)
                    .size(50.dp)
                    .clip(CircleShape),
                )
            Text(text = "Navarro Federico")




        }

    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        CursoAndroidComposeTheme {
            BusinessCardApp()
        }

    }
}
