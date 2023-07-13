package com.pizza.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pizza.R
import com.pizza.ui.composable.Appbar
import com.pizza.ui.composable.ImageSlider
import com.pizza.ui.composable.PizzaSizeItem
import com.pizza.utils.Constants
import com.pizza.ui.theme.Typography

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 1
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
        )
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    onSelectSize: (PizzaSizesUIState) -> Unit,
    pagerState : PagerState,
    state: MainScreenUIState,
) {

    Column(   modifier = modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,) {
        Box( modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ){
            Image(
                painter = painterResource(id = R.drawable.plate),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .height(250.dp),
            )
            ImageSlider(
                selectedSize = state.selectedSize.number,
                imageList = Constants.pizzas,
                pagerState = pagerState,)
        }
        Text(
                    stringResource(R.string._17),
            style = Typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp))
        Row(horizontalArrangement =  Arrangement.spacedBy(16.dp),) {
            state.pizzaSizes.forEach {
                PizzaSizeItem(
                    it,
                    isSelected = it.type == state.selectedSize.type,
                    onSelectSize = { onSelectSize(it) }
                )
            }
        }
        Text("CUSTOMIZE YOUR PIZZA",
            style = Typography.titleMedium,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start)
        )
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ){
            items(Constants.ingrdeients){
                Image(
                    painter = painterResource(id = it),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPrev() {
    MainScreen()
}

