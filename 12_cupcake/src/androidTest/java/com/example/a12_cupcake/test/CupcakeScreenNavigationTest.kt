package com.example.a12_cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import org.junit.Rule
import androidx.navigation.testing.TestNavHostController
import com.example.a12_cupcake.R
import com.example.a12_cupcake.CupcakeApp
import com.example.a12_cupcake.CupcakeScreen
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@get:Rule
val composeTestRule = createAndroidComposeRule<ComponentActivity>()

private lateinit var navController: TestNavHostController

class CupcakeScreenNavigationTest {
    @Test
    fun cupcakeNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(CupcakeScreen.Start.name)
    }

    @Test
    fun cupcakeNavHost_verifyBackNavigationNotShownOnStartOrderScreen() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }
    @Test
    fun cupcakeNavHost_clickOneCupcake_navigatesToSelectFlavorScreen() {
        composeTestRule.onNodeWithStringId(R.string.one_cupcake)
            .performClick()
        navController.assertCurrentRouteName(CupcakeScreen.Flavor.name)
    }
}
private fun navigateToFlavorScreen() {
    composeTestRule.onNodeWithStringId(R.string.one_cupcake)
        .performClick()
    composeTestRule.onNodeWithStringId(R.string.chocolate)
        .performClick()
}
private fun getFormattedDate():String{
    val calendar = Calendar.getInstance()
    calendar.add(java.util.Calendar.DATE, 1)
    val formatter = SimpleDateFormat("E MM d", Locale.getDefault())
    return formatter.format(calendar.time)
}
private fun navigateToPickupScreen(){
    navigateToFlavorScreen()
    composeTestRule.onNodeWithStringId(R.string.next)
        .performClick()
}
private fun performNavigateUp() {
    val backText = composeTestRule.activity.getString(R.string.back_button)
    composeTestRule.onNodeWithContentDescription(backText).performClick()
}
@Before
fun setupCupcakeNavHost() {
    composeTestRule.setContent {
        navController = TestNavHostController(LocalContext.current).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
        }
        CupcakeApp()
    }
}
