package com.zezzi.eventzezziapp.data.networking

import com.zezzi.eventzezziapp.data.networking.response.MealDetailsResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsByCategoryResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {
    private val api: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getCategories(): MealsCategoriesResponse {
        return api.getCategories()
    }

    suspend fun getMealsByCategory(category: String): MealsByCategoryResponse {
        return api.getMealsByCategory(category)
    }

    suspend fun getMealDetails(mealId: String): MealDetailsResponse {
        return api.getMealDetails(mealId)
    }
}