package com.michiura.datasource.repository.response

import com.google.gson.annotations.SerializedName
import java.util.Date

data class CharacterData(

    @SerializedName("id")
    val characterId: Int,

    @SerializedName("name")
    val characterName: String,

    @SerializedName("description")
    val characterDescription: String,

    @SerializedName("modified")
    val characterModifiedDate: Date,

    @SerializedName("thumbnail")
    val characterThumbnail: ThumbnailData
)
