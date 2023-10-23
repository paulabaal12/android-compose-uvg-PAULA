package com.zezzi.eventzezziapp.data.networking.response
import com.google.gson.annotations.SerializedName

data class Responsesss(val meals: List<Meal>) {

}

data class Meal(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    //@SerializedName("strMeal") val description: String,
    @SerializedName("strMealThumb") val imageUrl: String
)