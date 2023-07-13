package com.pizza.ui.screens

data class MainScreenUIState(
    val pizzaSizes: List<PizzaSizesUIState> = listOf(
        PizzaSizesUIState(type = "S", number = .55f),
        PizzaSizesUIState(type = "M", number = .6f),
        PizzaSizesUIState(type = "L", number = .65f),
        ),
    val selectedSize: PizzaSizesUIState = PizzaSizesUIState(type = "M", number = .5f),
)
