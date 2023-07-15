package com.pizza.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import com.pizza.ui.screens.uiState.MainScreenUIState
import com.pizza.ui.screens.uiState.PizzaSizesUIState
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

    fun onSelectIngredient(ingredientType: Ingredient,currentPizza:Int) {
        _state.update {
            it.copy(
                pizzas = it.pizzas.mapIndexed { index, pizza ->
                    if (index == currentPizza) {
                        pizza.copy(ingredients = pizza.ingredients.map { ingredient ->
                            if (ingredient.type == ingredientType) {
                                ingredient.copy(isSelected = !ingredient.isSelected)
                            } else {
                                ingredient
                            }
                        })
                    } else {
                        pizza
                    }
                }
            )
        }
    }
}