package com.michiura.datasource.network.response

import com.google.gson.annotations.SerializedName
import java.util.Date

data class CharacterResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("modified")
    val modified: Date,

    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse
)
