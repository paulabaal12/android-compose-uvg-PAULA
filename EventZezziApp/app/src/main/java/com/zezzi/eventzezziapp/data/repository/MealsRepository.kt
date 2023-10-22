package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealDetailsResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsByCategoryResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getCategories(): MealsCategoriesResponse? {
        return try {
            webService.getCategories()
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getMealsByCategory(category: String): MealsByCategoryResponse? {
        return try {
            webService.getMealsByCategory(category)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getMealDetails(mealId: String): MealDetailsResponse? {
        return try {
            webService.getMealDetails(mealId)
        } catch (e: Exception) {
            null
        }
    }
}