package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.MealDetailsResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsByCategoryResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    suspend fun getCategories(): MealsCategoriesResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): MealsByCategoryResponse

    @GET("lookup.php")
    suspend fun getMealDetails(@Query("i") mealId: String): MealDetailsResponse
}