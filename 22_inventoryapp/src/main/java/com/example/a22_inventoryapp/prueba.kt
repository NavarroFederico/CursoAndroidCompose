package com.example.a22_inventoryapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(device = "id:Nexus One")
@Composable
fun UserCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        )
        {

            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth(),

                )
            {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    NavigationItem(
                        label = R.string.perfil_extendido,
                        imageVector = Icons.Default.AccountCircle,
                        modifier = Modifier
                            .weight(1f)

                    )
                    NavigationItem(
                        label = R.string.carreras_extendida,
                        imageVector = Icons.AutoMirrored.Filled.MenuBook,
                        modifier = Modifier
                            .weight(1f)

                    )
                    NavigationItem(
                        label = R.string.office_365,
                        imageVector = Icons.Default.Email,
                        modifier = Modifier
                            .weight(1f)

                    )
                    NavigationItem(
                        label = R.string.mapa,
                        imageVector = Icons.Default.Map,
                        modifier = Modifier
                            .weight(1f)

                    )
                }
            }
        }

    }
}

@Composable
fun NavigationItem(@StringRes label: Int, imageVector: ImageVector, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            modifier = Modifier
                .shadow(12.dp, CardDefaults.shape)
                .background(Color(203, 228, 222))
                .padding(5.dp),
            onClick = {
                // navController.navigate(route = ScreenNav.Perfil.route)
            }
        )
        {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = Color(0, 100, 100),
                modifier = Modifier
            )
        }
        Text(
            modifier = Modifier.padding(
                start = 0.dp,
                top = 10.dp,
                bottom = 5.dp
            ),
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            color = Color(0, 100, 100),
            text = stringResource(label),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis

        )
    }

}