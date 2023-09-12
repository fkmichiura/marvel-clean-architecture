package com.michiura.datasource.network

import com.michiura.data.BuildConfig
import com.michiura.datasource.datasource.remote.MarvelRemoteService
import com.michiura.datasource.network.providers.provideOkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelServiceFactory {
    fun getMarvelService(): MarvelRemoteService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
        return retrofit.create(MarvelRemoteService::class.java)
    }
}
