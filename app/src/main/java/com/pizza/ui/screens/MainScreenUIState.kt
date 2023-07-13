package com.pizza.ui.screens

data class MainScreenUIState(
    val pizzaSizes: List<PizzaSizesUIState> = listOf(
        PizzaSizesUIState(type = "S", number = .45f),
        PizzaSizesUIState(type = "M", number = .5f),
        PizzaSizesUIState(type = "L", number = .55f),
        ),
    val selectedSize: PizzaSizesUIState = PizzaSizesUIState(type = "M", number = .5f),
)
