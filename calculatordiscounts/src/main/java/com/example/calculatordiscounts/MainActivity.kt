package com.example.calculatordiscounts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursoandroidcompose.ui.theme.TipCalculatorTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                Surface {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun TipTimeLayout() {
    var discountLimitInput by remember { mutableStateOf("") }
    var discountPercentInput by remember { mutableStateOf("") }
    val discountLimit = discountLimitInput.toDoubleOrNull() ?: 0.0
    val discountPercent = discountPercentInput.toDoubleOrNull() ?: 0.0
    val purchaseLimit = calculatePurchaseLimit(discountLimit, discountPercent)
    val purchaseLimitString = NumberFormat.getCurrencyInstance().format(purchaseLimit)
    val finalCost = calculateCostFinal(purchaseLimit, discountLimit)
    val finalCostString = NumberFormat.getCurrencyInstance().format(finalCost)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = stringResource(id = R.string.calculate_max_discount),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            label = R.string.discount_limit,
            leadingIcon = R.drawable.discount_limit_price,
            value = discountLimitInput,
            onValueChange = { discountLimitInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField(
            label = R.string.discount_percent,
            leadingIcon = R.drawable.percent_icon,
            value = discountPercentInput,
            onValueChange = { discountPercentInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Text(
            text = stringResource(id = R.string.to_take_full_advantage_of_the_promotion),
        )
        Text(
            text = stringResource(id = R.string.spend_a_total_of, purchaseLimitString),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(
                id = R.string.with_discount_percent,
                discountPercent
            )
                    + "\n" +
                    stringResource(id = R.string.and_discount_limit, discountLimit)
                    + "\n" +
                    stringResource(id = R.string.final_cost_with_applied_discount, finalCostString),
            textAlign = TextAlign.Left,
            modifier = Modifier.align(alignment = Alignment.Start)
        )
        Spacer(modifier = Modifier.height(150.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = label)) },
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
    )
}

@VisibleForTesting
internal fun calculatePurchaseLimit(discountLimit: Double, discountPercent: Double): Double {

    val purchaseLimit = discountLimit * 100 / discountPercent
    return (if (discountPercent != 0.0) purchaseLimit else 0.0)
}

@VisibleForTesting
internal fun calculateCostFinal(purchaseLimit: Double, discountLimit: Double): Double {

    val finalCost = purchaseLimit.minus((discountLimit))
    return if (discountLimit != 0.0) finalCost else 0.0
}

@Preview(showBackground = true)
@Composable
fun TipTimeLayoutPreview() {
    TipCalculatorTheme {
        TipTimeLayout()
    }
}