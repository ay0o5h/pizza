package com.pizza.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.BiasAlignment


@Composable
 fun AnimateBackgroundAlignment(
    targetValue: Float
): State<BiasAlignment> {
    val horizontalBias by animateFloatAsState(
        targetValue = targetValue,
        animationSpec = tween(500)
    )
    return remember { derivedStateOf { BiasAlignment(horizontalBias = horizontalBias, verticalBias = 0f) } }
}