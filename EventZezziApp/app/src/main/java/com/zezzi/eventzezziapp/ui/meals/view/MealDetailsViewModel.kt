package com.zezzi.eventzezziapp.ui.meals.view

import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository

class MealDetailsViewModel (private val repository: MealsRepository = MealsRepository()) : ViewModel() {

    suspend fun getMeals(): MealsCategoriesResponse? {
        return repository.getMeals()
    }
}
