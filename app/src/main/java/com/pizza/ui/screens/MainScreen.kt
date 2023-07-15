package com.pizza.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pizza.R
import com.pizza.ui.composable.AddToCartButton
import com.pizza.ui.composable.AnimateBackgroundAlignment
import com.pizza.ui.composable.Appbar
import com.pizza.ui.composable.PizzaIngredient
import com.pizza.ui.screens.uiState.MainScreenUIState
import com.pizza.ui.screens.uiState.PizzaSizesUIState
import com.pizza.ui.theme.Typography
import com.pizza.ui.theme.green
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 0
    )
    Scaffold(
        containerColor= Color.White,
        topBar = {
            Appbar(title="Pizza" , onNavigateUp = {})
        },
    ){
        MainContent(
            modifier= Modifier.padding(it),
            onSelectSize = { size: PizzaSizesUIState -> viewModel.onSelectSize(size) },
            pagerState = pagerState,
            state=state,
            onSelectIngredient = { ingredient: Ingredient, index: Int -> viewModel.onSelectIngredient(ingredient, index) },
        )
    }
}
@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class,)
@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    onSelectSize: (PizzaSizesUIState) -> Unit,
    pagerState : PagerState,
    state: MainScreenUIState,
    onSelectIngredient: (Ingredient,Int) -> Unit,
) {
    val alignment by AnimateBackgroundAlignment(
        when (state.selectedSize.type) {
            "M" -> 0f
            "L" -> .6f
            else -> -.6f
        }
    )
    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        verticalArrangement= Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,) {
        Box( modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.plate),
                contentDescription = "",
                modifier = Modifier.size(250.dp)
            )
            HorizontalPager(
                state = pagerState,
                pageCount = state.pizzas.size,
                modifier = Modifier.fillMaxWidth(),
            ) {
                val animatedScale by animateFloatAsState(
                    targetValue =  state.selectedSize.number,
                    animationSpec = tween(durationMillis = 200)
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .height(250.dp)
                    .scale(animatedScale),
                ) {
                    Image(
                        painter = painterResource(id = state.pizzas[it].image),
                        contentDescription = "",
                        alignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    )
                    state.pizzas[pagerState.currentPage].ingredients.forEach() { ingredient ->
                        PizzaIngredient(
                            images =ingredient.ingredientImages,
                            isSelected = ingredient.isSelected,
                        )
                    }
                }
            }
        }
        Text(
            stringResource(R.string._17),
            style = Typography.titleLarge,
            modifier = Modifier.padding(vertical = 16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)){
            Card(
                modifier = Modifier
                    .size(56.dp)
                    .align(alignment),
                shape= CircleShape,
                colors=CardDefaults.cardColors(
                    containerColor = Color.White,

                ),
                elevation = CardDefaults.elevatedCardElevation(10.dp),
            ){}
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 6.dp)) {
                state.pizzaSizes.forEach {
                    Text(text = it.type,
                        textAlign= TextAlign.Center,
                        style = Typography.bodyMedium.copy(color = Color.Black, fontSize = 16.sp,),
                        modifier = Modifier .clickable{ onSelectSize(it)  }
                    )
                }
            }
        }
        Text(
           stringResource(R.string.customize_your_pizza),
            style = Typography.titleMedium,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start)
        )
        LazyRow(
            modifier = Modifier.align(Alignment.Start),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
        ){
            items(state.pizzas[pagerState.currentPage].ingredients){
                Surface(
                    modifier = Modifier
                        .size(50.dp)
                        .clickable(indication = null,
                            interactionSource = remember { MutableInteractionSource() }) {
                            onSelectIngredient(it.type, pagerState.currentPage)
                        },
                    shape= CircleShape,
                    color=if(it.isSelected) green else Color.Transparent,
                ){
                    Image(
                        painter = painterResource(id = it.image),
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }
        }
        Box(Modifier.weight(1f), contentAlignment = Alignment.BottomCenter) {
            AddToCartButton(
                onClick = { },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPrev() {
    MainScreen()
}

