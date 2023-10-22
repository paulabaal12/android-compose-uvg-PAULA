package com.zezzi.eventzezziapp.data.networking.response

import com.google.gson.annotations.SerializedName

data class AreaResponse(
    @SerializedName("strArea") val name: String
)