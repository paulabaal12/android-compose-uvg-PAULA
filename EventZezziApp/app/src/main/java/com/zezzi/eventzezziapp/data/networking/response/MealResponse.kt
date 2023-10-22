package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(val categories: List<CategoryResponse>) {

}


//data class MealResponse(
  //  @SerializedName("idCategory") val id: String,
    //@SerializedName("strCategory") val name: String,
   // @SerializedName("strCategoryDescription") val description: String,
    //@SerializedName("strCategoryThumb") val imageUrl: String,
   // @SerializedName("strMeal") val name: String,
    //@SerializedName("strMealThumb") val imageUrl: String,
    //@SerializedName("idMeal") val id: String
data class MealResponse(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
    @SerializedName("idMeal") val id: String
)