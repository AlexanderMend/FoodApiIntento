package com.example.foodapi.data

import com.example.foodapi.model.Meal
import com.example.foodapi.model.RecipeFood
import com.example.foodapi.network.FoodApi

interface FoodRecipeRepository{
    suspend fun getFoodRecipe(): RecipeFood
}

class NetworkFoodRecipeRepository: FoodRecipeRepository{
    override suspend fun getFoodRecipe(): RecipeFood {
        return FoodApi.retrofitService.getRecipe()
    }
}