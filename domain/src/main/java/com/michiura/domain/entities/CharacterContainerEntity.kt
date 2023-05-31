package com.michiura.domain.entities

import com.google.gson.annotations.SerializedName

data class CharactersListData(

    @SerializedName("total")
    val total: Int,

    @SerializedName("count")
    val count: Int,

    @SerializedName("results")
    val charactersList: List<CharacterData>
)
