package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.Responsesss
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse

    @GET("filter.php")
    suspend fun getFilter(@Query("c") category: String): Responsesss
}