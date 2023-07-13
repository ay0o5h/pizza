package com.pizza.ui.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pizza.ui.screens.PizzaSizesUIState
import com.pizza.ui.theme.Typography


@Composable
fun PizzaSizeItem(
    pizzaSizesUIState: PizzaSizesUIState,
    isSelected : Boolean = false,
    onSelectSize: () -> Unit = {},
) {
    val buttonElevation by animateDpAsState(if (isSelected) 5.dp else 0.dp)
    Button(
        onClick = { onSelectSize() },
        modifier = Modifier
            .size(56.dp),
        elevation= ButtonDefaults.buttonElevation(buttonElevation),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
    ) {
        Text(text = pizzaSizesUIState.type,
            style = Typography.bodyMedium.copy(color = Color.Black, fontSize = 16.sp,))
    }
}