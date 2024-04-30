package com.example.a16_mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a16_mycity.ui.CityApp
import com.example.a16_mycity.ui.theme.CursoAndroidComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursoAndroidComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    CityApp(windowSize = windowSize.widthSizeClass)

                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CityAppCompactPreview() {
    CursoAndroidComposeTheme {
        Surface {
            CityApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CityAppMediumPreview() {
    CursoAndroidComposeTheme {
        Surface {
            CityApp(windowSize = WindowWidthSizeClass.Medium)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CityAppExpandedPreview() {
    CursoAndroidComposeTheme {
        Surface {
            CityApp(windowSize = WindowWidthSizeClass.Expanded)
        }
    }
}