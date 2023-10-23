package com.zezzi.eventzezziapp.data.repository

import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.Responsesss
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            webService.getMeals()
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getFilter(category: String): Responsesss? {
        return try {
            webService.getFilter(category)
        } catch (e: Exception) {
            null
        }
    }
}

