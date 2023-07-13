package com.pizza.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
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
        Log.d("AYA", "oSelectDay: $pizzaSizesUIState")
        _state.update {
            it.copy(selectedSize = pizzaSizesUIState)
        }
    }
}