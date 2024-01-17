package com.example.cursoandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursoandroidcompose.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    val imageResource = when (currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val contentDescription = when (currentStep) {
        1 -> stringResource(id = R.string.lemon_tree_content_description)
        2 -> stringResource(id = R.string.lemon_content_description)
        3 -> stringResource(id = R.string.glass_of_lemonade_content_description)
        else -> stringResource(id = R.string.empty_glass_content_description)
    }

    val textDescription = when (currentStep) {
        1 -> stringResource(id = R.string.Tap_the_lemon_tree_to_select_a_lemon)
        2 -> stringResource(id = R.string.Keep_tapping_the_lemon_to_squeeze_it)
        3 -> stringResource(id = R.string.Tap_the_lemonade_to_drink_it)
        else -> {
            stringResource(id = R.string.Tap_the_empty_glass_to_start_again)
        }
    }
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = contentDescription,
                modifier = Modifier
                    .wrapContentSize()
                    .border(
                        width = 2.dp,
                        color = Color(105, 205, 216),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .background(color = Color(105, 205, 216), shape = RoundedCornerShape(20.dp))
                    .clickable(onClickLabel = "Click Image", onClick = {

                        when (currentStep) {
                            1 -> currentStep = 2
                            2 -> currentStep = 3
                            3 -> currentStep = 4
                            4 -> currentStep = 1

                        }
                    })

            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = textDescription,
                fontSize = 18.sp
            )


        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}

