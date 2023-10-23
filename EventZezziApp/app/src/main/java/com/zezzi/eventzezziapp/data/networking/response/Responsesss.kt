package com.zezzi.eventzezziapp.data.networking.response
import com.google.gson.annotations.SerializedName

data class Responsesss(val meals: List<Meal>) {

}

data class Meal(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)