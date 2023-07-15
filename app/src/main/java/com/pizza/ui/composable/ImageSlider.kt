package com.pizza.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pizza.ui.screens.uiState.PizzaUIState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(
    imageList: List<PizzaUIState>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    selectedSize: Float = .5f,
) {
    HorizontalPager(
        state = pagerState,
        pageCount = imageList.size,
        contentPadding = PaddingValues(horizontal = 3.dp),
        pageSpacing = 8.dp,
        modifier = modifier,
    ) {
        val animatedScale by animateFloatAsState(
            targetValue = selectedSize,
            animationSpec = tween(durationMillis = 200)
        )
        Image(
            painter = painterResource(id = imageList[it].image),
            contentDescription = "",
            modifier = Modifier
                .scale(animatedScale)
        )
    }

}