package com.pizza.ui.screens.uiState

import com.pizza.ui.screens.Ingredient

data class IngredientUIState(
    val image: Int,
    val type: Ingredient,
    val isSelected: Boolean = false,
    val ingredientImages :List<Int> = emptyList()
)
