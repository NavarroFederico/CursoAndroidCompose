package com.example.cursoandroidcompose

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
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
    var descriptionVisibility by remember { androidx.compose.runtime.mutableStateOf(false) }
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
                painter = painterResource(id = R.drawable.lemon_tree),
                contentDescription = stringResource(
                    id = R.string.lemon_tree_content_description
                ),
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = Color(105, 205, 216),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .background(color = Color(105, 205, 216), shape = RoundedCornerShape(20.dp))
                    .pointerInput(Unit) {
                        detectDragGesturesAfterLongPress(onDragStart = {
                            descriptionVisibility = true
                        }, onDrag = { change, dragAmount ->
                            descriptionVisibility = false
                            println("DRAGGING$ dragAmount")

                        })
                    }
                    .clickable(onClickLabel = "Click Image", onClick = { })

            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.Tap_the_lemon_tree_to_select_a_lemon),
                fontSize = 18.sp
            )


        }
        if (descriptionVisibility) {
            showDragDescription()
        }
    }
}


@Composable
fun showDragDescription() {
    val description = stringResource(id = R.string.Tap_the_lemon_tree_to_select_a_lemon)
    val activity = (LocalContext.current as Activity)
    Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}

