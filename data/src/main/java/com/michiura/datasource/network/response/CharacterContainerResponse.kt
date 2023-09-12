package com.michiura.datasource.network.response

import com.google.gson.annotations.SerializedName

data class CharacterContainerResponse(
    @SerializedName("total")
    val total: Int,

    @SerializedName("count")
    val count: Int,

    @SerializedName("results")
    val results: List<CharacterResponse>
)
