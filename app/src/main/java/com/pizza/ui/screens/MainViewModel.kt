package com.pizza.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import com.pizza.ui.screens.uiState.IngredientUIState
import com.pizza.ui.screens.uiState.MainScreenUIState
import com.pizza.ui.screens.uiState.PizzaSizesUIState
import com.pizza.ui.screens.uiState.PizzaUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor() :ViewModel() {

    private val _state = MutableStateFlow(MainScreenUIState())
    val state = _state.asStateFlow()

    fun onSelectSize(pizzaSizesUIState: PizzaSizesUIState) {
        _state.update {
            it.copy(selectedSize = pizzaSizesUIState)
        }
    }
   private  fun updatePizzaIngredients(pizza: PizzaUIState, ingredientType: Ingredient,
          toggleFunction: (IngredientUIState) -> IngredientUIState): PizzaUIState {
        val updatedIngredients = pizza.ingredients.map { ingredient ->
            if (ingredient.type == ingredientType) {
                toggleFunction(ingredient)
            } else {
                ingredient
            }
        }
        return pizza.copy(ingredients = updatedIngredients)
    }

    private  fun updatePizzasList(pizzas: List<PizzaUIState>, currentPizza: Int, ingredientType: Ingredient,
           toggleFunction: (IngredientUIState) -> IngredientUIState): List<PizzaUIState> {
        return pizzas.mapIndexed { index, pizza ->
            if (index == currentPizza) {
                updatePizzaIngredients(pizza, ingredientType, toggleFunction)
            } else {
                pizza
            }
        }
    }
   private fun toggleIngredientSelection(ingredient: IngredientUIState): IngredientUIState {
        return ingredient.copy(isSelected = !ingredient.isSelected)
    }


    fun onSelectIngredient(ingredientType: Ingredient, currentPizza: Int) {
        _state.update {
            it.copy(pizzas = updatePizzasList(it.pizzas, currentPizza, ingredientType, ::toggleIngredientSelection))
        }
    }

}