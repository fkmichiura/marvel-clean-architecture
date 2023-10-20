package com.michiura.datasource.network.providers

import com.michiura.data.BuildConfig
import com.michiura.datasource.commons.Constants.MD5.HASH_QUERY_PARAM
import com.michiura.datasource.commons.Constants.PUBLIC_API_KEY_QUERY_PARAM
import com.michiura.datasource.commons.Constants.TIMPESTAMP_QUERY_PARAM
import com.michiura.datasource.network.extensions.AuthExtensions.getMd5Digest
import com.michiura.datasource.network.extensions.AuthExtensions.timestamp
import okhttp3.Interceptor
import okhttp3.Response
import java.util.Date

class AuthInterceptorProvider : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        val url = request
            .url()
            .newBuilder()
            .addQueryParameter(TIMPESTAMP_QUERY_PARAM, Date().timestamp)
            .addQueryParameter(PUBLIC_API_KEY_QUERY_PARAM, BuildConfig.PUBLIC_API_KEY)
            .addQueryParameter(HASH_QUERY_PARAM, getMd5Digest)
            .build()

        return chain.proceed(
            request
                .newBuilder()
                .url(url)
                .build()
        )
    }
}
