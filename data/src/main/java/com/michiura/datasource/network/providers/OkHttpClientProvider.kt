package com.michiura.datasource.network.providers

import okhttp3.OkHttpClient

fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(AuthInterceptorProvider())
        .build()
