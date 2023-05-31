package com.michiura.datasource.datasource.remote

import com.michiura.datasource.network.response.CharacterWrapperResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelRemoteService {
    @GET("/v1/public/characters")
    fun getCharactersList(): CharacterWrapperResponse

    @GET("/v1/public/characters/{id}")
    fun getCharacterDetails(
        @Path("id") characterId: Int
    ): CharacterWrapperResponse
}
