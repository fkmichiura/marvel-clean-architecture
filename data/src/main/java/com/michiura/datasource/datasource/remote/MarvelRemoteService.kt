package com.michiura.datasource.datasource.remote

import com.michiura.data.repository.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelRemoteService {
    @GET("/v1/public/characters")
    fun getCharactersList(): CharactersResponse

    @GET("/v1/public/characters/{id}")
    fun getCharacterDetails(
        @Path("id") characterId: Int
    ): CharactersResponse
}