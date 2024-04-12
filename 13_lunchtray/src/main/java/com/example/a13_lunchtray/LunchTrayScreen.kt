/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.a13_lunchtray

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a13_lunchtray.datasource.DataSource
import com.example.a13_lunchtray.ui.AccompanimentMenuScreen
import com.example.a13_lunchtray.ui.CheckoutScreen
import com.example.a13_lunchtray.ui.EntreeMenuScreen
import com.example.a13_lunchtray.ui.OrderViewModel
import com.example.a13_lunchtray.ui.SideDishMenuScreen
import com.example.a13_lunchtray.ui.StartOrderScreen


/**
 * enum class to hold constants for each of the following Lunch Tray app screens:
 *
 * Start
 * Entree menu
 * Side dish menu
 * Accompaniment menu
 * Checkout
 * Each screen should have an associated title in the form of a string. The strings are available in the starter code as resources.
 */
enum class LunchTrayScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    EntreMenu(title = R.string.choose_entree),
    SideDishMenu(title = R.string.choose_side_dish),
    AccompanimentMenu(title = R.string.choose_accompaniment),
    Checkout(title = R.string.order_checkout)
}
// TODO: AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp() {
    //  Create Controller and initialization
    val navController = rememberNavController()


    // Create ViewModel
    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            // TODO: AppBar
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        // Navigation host
        NavHost(navController = navController, startDestination = LunchTrayScreen.Start.name) {
            composable(LunchTrayScreen.Start.name) {
                StartOrderScreen(onStartOrderButtonClicked = { /*TODO*/ })
            }
            composable(LunchTrayScreen.EntreMenu.name) {
                EntreeMenuScreen(
                    options = DataSource.entreeMenuItems,
                    onCancelButtonClicked = { /*TODO*/ },
                    onNextButtonClicked = { /*TODO*/ },
                    onSelectionChanged = {  }
                )
            }
            composable(LunchTrayScreen.SideDishMenu.name) {
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = { /*TODO*/ },
                    onNextButtonClicked = { /*TODO*/ },
                    onSelectionChanged = { }
                )
            }
            composable(LunchTrayScreen.AccompanimentMenu.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = { /*TODO*/ },
                    onNextButtonClicked = { /*TODO*/ },
                    onSelectionChanged = { }
                )
            }
            composable(LunchTrayScreen.Checkout.name) {
                CheckoutScreen(
                    orderUiState = uiState,
                    onNextButtonClicked = { /*TODO*/ },
                    onCancelButtonClicked = { /*TODO*/ })
            }
            // Add more destinations similarly.
        }
    }
}
