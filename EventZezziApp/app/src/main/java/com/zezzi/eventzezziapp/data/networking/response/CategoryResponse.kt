package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("strCategory") val name: String,
    val imageUrl: String
)
