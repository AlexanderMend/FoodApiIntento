package com.example.foodapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapi.data.NetworkFoodRecipeRepository
import com.example.foodapi.model.Meal
import com.example.foodapi.model.RecipeFood
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface FoodUiState{
    data class Success(val recipe:RecipeFood): FoodUiState
    object Error: FoodUiState
    object Loading: FoodUiState
}
class FoodViewModel:ViewModel(){
    var foodUiState:FoodUiState by mutableStateOf(FoodUiState.Loading)
        private set
    init{
        getFoodRecipe()
    }
    private fun getFoodRecipe(){
        viewModelScope.launch {
            foodUiState = try {
                val foodRecipeRepository = NetworkFoodRecipeRepository()
                val result = foodRecipeRepository.getFoodRecipe()
                FoodUiState.Success(result)
            } catch (e: IOException){
                FoodUiState.Error
            }
        }
    }
}