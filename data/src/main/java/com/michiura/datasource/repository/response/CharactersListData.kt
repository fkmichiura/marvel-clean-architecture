package com.michiura.data.repository.response

import com.google.gson.annotations.SerializedName

data class CharactersListData(

    @SerializedName("results")
    val charactersList: List<CharacterData>
)
