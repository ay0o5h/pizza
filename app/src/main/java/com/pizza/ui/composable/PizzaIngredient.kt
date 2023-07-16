package com.pizza.ui.composable

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class)
@Composable
fun PizzaIngredient(
    images : List<Int>,
    isSelected: Boolean =false,
    modifier: Modifier = Modifier,
    pagerState: PagerState,
) {
        Box(modifier = modifier.size(250.dp)) {
            if(pagerState.isScrollInProgress){
                images.filter { isSelected }.forEach { image ->
                    val randomOffsetX = remember { mutableStateOf(Random.nextInt(80, 300 )) }
                    val randomOffsetY = remember { mutableStateOf(Random.nextInt(10, 210)) }
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp).offset(randomOffsetX.value.dp, randomOffsetY.value.dp)
                    )
                }
            }else{
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
}