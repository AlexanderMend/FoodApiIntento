package com.example.foodapi.network

import com.example.foodapi.model.Meal
import com.example.foodapi.model.RecipeFood
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://www.themealdb.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()
interface FoodApiService{
    @GET("v1/1/random.php")
    suspend fun getRecipe(): RecipeFood
}
object FoodApi{
    val retrofitService: FoodApiService by lazy {
        retrofit.create(FoodApiService::class.java)
    }
}