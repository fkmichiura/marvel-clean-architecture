package com.michiura.datasource.network.response

import com.google.gson.annotations.SerializedName

data class CharactersResponse(

    @SerializedName("code")
    val code: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("data")
    val data: CharactersContainerResponse
)
