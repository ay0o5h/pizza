package com.pizza.ui.screens.uiState

import com.pizza.R
import com.pizza.ui.screens.Ingredient
import com.pizza.utils.Constants

data class MainScreenUIState(
    val pizzas: List<PizzaUIState> =  listOf(
        PizzaUIState(
            image = R.drawable.bread_1,
            ingredients = listOf(
                IngredientUIState(image =  R.drawable.basil_3, type = Ingredient.BASIL, isSelected = false ,ingredientImages=Constants.basils),
                IngredientUIState(image =  R.drawable.onion_10, type = Ingredient.ONION, isSelected = false,ingredientImages=Constants.onions),
                IngredientUIState(image = R.drawable.broccoli_3, type = Ingredient.BROCCOLI, isSelected = false,ingredientImages=Constants.broccolis),
                IngredientUIState(image = R.drawable.mushroom_3, type = Ingredient.MUSHROOM, isSelected = false,ingredientImages=Constants.mushrooms),
                IngredientUIState(image = R.drawable.sausage_3, type = Ingredient.SAUSAGE, isSelected = false,ingredientImages=Constants.sausages),
            ),
        ),
        PizzaUIState(
            image = R.drawable.bread_2,
            ingredients = listOf(
                IngredientUIState(image =  R.drawable.basil_3, type = Ingredient.BASIL, isSelected = false ,ingredientImages=Constants.basils),
                IngredientUIState(image =  R.drawable.onion_10, type = Ingredient.ONION, isSelected = false,ingredientImages=Constants.onions),
                IngredientUIState(image = R.drawable.broccoli_3, type = Ingredient.BROCCOLI, isSelected = false,ingredientImages=Constants.broccolis),
                IngredientUIState(image = R.drawable.mushroom_3, type = Ingredient.MUSHROOM, isSelected = false,ingredientImages=Constants.mushrooms),
                IngredientUIState(image = R.drawable.sausage_3, type = Ingredient.SAUSAGE, isSelected = false,ingredientImages=Constants.sausages),
            ),
        ),
        PizzaUIState(
            image = R.drawable.bread_3,
            ingredients = listOf(
                IngredientUIState(image =  R.drawable.basil_3, type = Ingredient.BASIL, isSelected = false ,ingredientImages=Constants.basils),
                IngredientUIState(image =  R.drawable.onion_10, type = Ingredient.ONION, isSelected = false,ingredientImages=Constants.onions),
                IngredientUIState(image = R.drawable.broccoli_3, type = Ingredient.BROCCOLI, isSelected = false,ingredientImages=Constants.broccolis),
                IngredientUIState(image = R.drawable.mushroom_3, type = Ingredient.MUSHROOM, isSelected = false,ingredientImages=Constants.mushrooms),
                IngredientUIState(image = R.drawable.sausage_3, type = Ingredient.SAUSAGE, isSelected = false,ingredientImages=Constants.sausages),
            ),
        ),
        PizzaUIState(
            image = R.drawable.bread_4,
            ingredients = listOf(
                IngredientUIState(image =  R.drawable.basil_3, type = Ingredient.BASIL, isSelected = false ,ingredientImages=Constants.basils),
                IngredientUIState(image =  R.drawable.onion_10, type = Ingredient.ONION, isSelected = false,ingredientImages=Constants.onions),
                IngredientUIState(image = R.drawable.broccoli_3, type = Ingredient.BROCCOLI, isSelected = false,ingredientImages=Constants.broccolis),
                IngredientUIState(image = R.drawable.mushroom_3, type = Ingredient.MUSHROOM, isSelected = false,ingredientImages=Constants.mushrooms),
                IngredientUIState(image = R.drawable.sausage_3, type = Ingredient.SAUSAGE, isSelected = false,ingredientImages=Constants.sausages),
            ),
        ),
        PizzaUIState(
            image = R.drawable.bread_5,
            ingredients = listOf(
                IngredientUIState(image =  R.drawable.basil_3, type = Ingredient.BASIL, isSelected = false ,ingredientImages=Constants.basils),
                IngredientUIState(image =  R.drawable.onion_10, type = Ingredient.ONION, isSelected = false,ingredientImages=Constants.onions),
                IngredientUIState(image = R.drawable.broccoli_3, type = Ingredient.BROCCOLI, isSelected = false,ingredientImages=Constants.broccolis),
                IngredientUIState(image = R.drawable.mushroom_3, type = Ingredient.MUSHROOM, isSelected = false,ingredientImages=Constants.mushrooms),
                IngredientUIState(image = R.drawable.sausage_3, type = Ingredient.SAUSAGE, isSelected = false,ingredientImages=Constants.sausages),
            ),
        ),
    ),
    val pizzaSizes: List<PizzaSizesUIState> = listOf(
        PizzaSizesUIState(type = "S", number = .7f),
        PizzaSizesUIState(type = "M", number = .85f),
        PizzaSizesUIState(type = "L", number = .8f),
        ),
    val selectedSize: PizzaSizesUIState = PizzaSizesUIState(type = "M", number = .5f),
)




