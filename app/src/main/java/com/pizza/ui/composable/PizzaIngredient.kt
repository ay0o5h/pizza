package com.pizza.ui.composable

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PizzaIngredient(
    images : List<Int>,
    isSelected: Boolean =false,
    modifier: Modifier = Modifier,
) {
        Box(modifier = modifier.size(250.dp)) {
            androidx.compose.animation.AnimatedVisibility(
                visible = isSelected,
                enter = scaleIn(initialScale = 5f) ,
                exit = scaleOut(),
            ) {
            images.forEach { image ->
                val randomOffsetX = remember { mutableStateOf(Random.nextInt(80, 300 )) }
                val randomOffsetY = remember { mutableStateOf(Random.nextInt(10, 210)) }
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp).offset(randomOffsetX.value.dp, randomOffsetY.value.dp)
                )
            }
            }
        }
}