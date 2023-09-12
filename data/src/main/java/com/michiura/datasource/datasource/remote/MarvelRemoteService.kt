package com.michiura.datasource.datasource.remote

import com.michiura.datasource.commons.Constants.Endpoints
import com.michiura.datasource.network.response.CharacterWrapperResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelRemoteService {
    @GET(Endpoints.CHARACTERS)
    fun getCharactersList(): CharacterWrapperResponse

    @GET("${Endpoints.CHARACTERS}/{id}")
    fun getCharacterDetails(
        @Path("id") characterId: Int
    ): CharacterWrapperResponse
}
