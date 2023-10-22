package com.zezzi.eventzezziapp.data.networking.response

data class MealDetailsResponse(
    val id: String,
    val name: String,
    val category: String,
    val instructions: String,
    val ingredients: List<String>,
    val imageUrl: String,
    val videoUrl: String?
)