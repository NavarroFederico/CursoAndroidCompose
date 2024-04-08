package com.example.a10_dessertclicker.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a10_dessertclicker.R
import com.example.a10_dessertclicker.ui.theme.DessertClickerTheme

/**
 * Composable principal para la aplicación Dessert Clicker.
 *
 * Esta función Composable es el punto de entrada principal para la aplicación Dessert Clicker.
 * Construye la estructura general de la aplicación y delega la lógica de la interfaz de usuario
 * al `DessertViewModel`.
 *
 * @param dessertViewModel ViewModel de la aplicación Dessert Clicker (DessertViewModel - valor por defecto es viewModel()).
 *
 * @Composable
 * Esta función es declarada como Composable, lo que significa que puede ser utilizada para construir
 * la interfaz de usuario de forma declarativa.
 */
@Composable
fun DessertClickerApp(
    dessertViewModel: DessertViewModel = viewModel()
) {
    val dessertUiState by dessertViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            val intentContext = LocalContext.current
            val layoutDirection = LocalLayoutDirection.current
            DessertClickerAppBar(
                onShareButtonClicked = {
                    dessertViewModel.shareSoldDessertsInformation(
                        intentContext = intentContext,
                        dessertsSold = dessertUiState.dessertsSold,
                        revenue = dessertUiState.revenue
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = WindowInsets.safeDrawing
                            .asPaddingValues()
                            .calculateStartPadding(layoutDirection),
                        end = WindowInsets.safeDrawing
                            .asPaddingValues()
                            .calculateEndPadding(layoutDirection),
                    )
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    ) { contentPadding ->
        DessertClickerScreen(
            revenue = dessertUiState.revenue,
            dessertsSold = dessertUiState.dessertsSold,
            dessertImageId = dessertUiState.currentDessertImageId,
            onDessertClicked = { dessertViewModel.onDessertClicked() },
            modifier = Modifier.padding(contentPadding)
        )
    }
}

/**
 * Composable privado para la barra de la aplicación Dessert Clicker.
 *
 * Esta función Composable privada se utiliza para crear la barra de la aplicación
 * que muestra el nombre de la aplicación y un botón para compartir.
 *
 * @param onShareButtonClicked Lambda que se invoca al hacer clic en el botón de compartir ((): Unit).
 * @param modifier Modificador opcional para personalizar el estilo de la barra (el valor por defecto es `Modifier`).
 *
 * @Composable
 * Esta función es declarada como Composable, lo que significa que puede ser utilizada para construir
 * la interfaz de usuario de forma declarativa.
 *
 * **Importante:** Esta función es privada y solo se debe utilizar dentro del contexto adecuado.
 */
@Composable
private fun DessertClickerAppBar(
    onShareButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium)),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleLarge,
        )
        IconButton(
            onClick = onShareButtonClicked,
            modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_medium)),
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(R.string.share),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}


/**
 * Composable para la pantalla principal de la aplicación Dessert Clicker.
 *
 * Esta función Composable representa la pantalla principal de la aplicación Dessert Clicker.
 * Muestra una imagen de fondo de panadería, una imagen del postre actual en el centro y
 * la información de la transacción (ingresos y postres vendidos) en la parte inferior.
 *
 * @param revenue Ingresos totales generados por la venta de postres (Int).
 * @param dessertsSold Cantidad total de postres vendidos (Int).
 * @param dessertImageId Recurso identificador del drawable que representa la imagen del postre actual (Int - @DrawableRes).
 * @param onDessertClicked Lambda que se invoca cuando se hace clic en la imagen del postre ((): Unit).
 * @param modifier Modificador opcional para personalizar el estilo de la pantalla (Modifier - valor por defecto es Modifier).
 *
 * @Composable
 * Esta función es declarada como Composable, lo que significa que puede ser utilizada para construir
 * la interfaz de usuario de forma declarativa.
 */
@Composable
fun DessertClickerScreen(
    revenue: Int,
    dessertsSold: Int,
    @DrawableRes dessertImageId: Int,
    onDessertClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.bakery_back),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(dessertImageId),
                    contentDescription = null,
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.image_size))
                        .height(dimensionResource(R.dimen.image_size))
                        .align(Alignment.Center)
                        .clickable { onDessertClicked() },
                    contentScale = ContentScale.Crop,
                )
            }
            TransactionInfo(
                revenue = revenue,
                dessertsSold = dessertsSold,
                modifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer)
            )
        }
    }
}

/**
 * Composable privado para mostrar la información de la transacción (postres vendidos e ingresos).
 *
 * Esta función Composable privada se utiliza dentro de `DessertClickerScreen` para mostrar
 * la cantidad total de postres vendidos y los ingresos totales generados.
 *
 * @param revenue Ingresos totales generados por la venta de postres (Int).
 * @param dessertsSold Cantidad total de postres vendidos (Int).
 * @param modifier Modificador opcional para personalizar el estilo del contenedor (Modifier - valor por defecto es Modifier).
 *
 * @Composable
 * Esta función es declarada como Composable, lo que significa que puede ser utilizada para construir
 * la interfaz de usuario de forma declarativa.
 *
 * **Importante:** Esta función es privada y solo se debe utilizar dentro de `DessertClickerScreen`.
 */
@Composable
private fun TransactionInfo(
    revenue: Int,
    dessertsSold: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        DessertsSoldInfo(
            dessertsSold = dessertsSold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
        RevenueInfo(
            revenue = revenue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}

/**
 * Composable privado para mostrar la información de los ingresos totales.
 *
 * Esta función Composable privada se utiliza dentro de `TransactionInfo` para mostrar
 * la cantidad total de ingresos generados por la venta de postres.
 *
 * @param revenue Ingresos totales generados (Int).
 * @param modifier Modificador opcional para personalizar el estilo del contenedor (el valor por defecto es `Modifier`).
 *
 * @Composable
 * Esta función es declarada como Composable, lo que significa que puede ser utilizada para construir
 * la interfaz de usuario de forma declarativa.
 *
 * **Importante:** Esta función es privada y solo se debe utilizar dentro de `TransactionInfo`.
 */
@Composable
private fun RevenueInfo(revenue: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(R.string.total_revenue),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = "$${revenue}",
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}

/**
 * Composable privado para mostrar la información de los postres vendidos.
 *
 * Esta función Composable privada se utiliza dentro de `TransactionInfo` para mostrar
 * la cantidad total de postres vendidos.
 *
 * @param dessertsSold Cantidad total de postres vendidos (Int).
 * @param modifier Modificador opcional para personalizar el estilo del contenedor (el valor por defecto es `Modifier`).
 *
 * @Composable
 * Esta función es declarada como Composable, lo que significa que puede ser utilizada para construir
 * la interfaz de usuario de forma declarativa.
 *
 * **Importante:** Esta función es privada y solo se debe utilizar dentro de `TransactionInfo`.
 */
@Composable
private fun DessertsSoldInfo(dessertsSold: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(R.string.dessert_sold),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = dessertsSold.toString(),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}

@Preview
@Composable
fun MyDessertClickerAppPreview() {
    DessertClickerTheme {
        DessertClickerApp()
    }
}