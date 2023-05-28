package com.michiura.datasource.network

import com.michiura.datasource.datasource.remote.MarvelRemoteService
import com.michiura.datasource.network.providers.provideOkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceFactory {

    fun createApiService(): MarvelRemoteService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()

        return retrofit.create(MarvelRemoteService::class.java)
    }

    companion object {
        private const val BASE_URL = "https://gateway.marvel.com/"
    }
}
