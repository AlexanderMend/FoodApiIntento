package com.example.foodapi.model

import kotlinx.serialization.Serializable
@Serializable
data class RecipeFood(
    val meals: List<Meal>
)

data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strDrinkAlternate: String?,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: String?,
    val strYoutube: String?,
    val ingredients: List<Ingredient>,
    val strSource: String?,
    val strImageSource: String?,
    val strCreativeCommonsConfirmed: String?,
    val dateModified: String?
)

data class Ingredient(
    val name: String,
    val measure: String?
)
