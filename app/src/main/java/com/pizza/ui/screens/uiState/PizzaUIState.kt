package com.pizza.ui.screens.uiState

data class PizzaUIState(
    val image: Int = 0,
    val ingredients: List<IngredientUIState> = emptyList(),
)