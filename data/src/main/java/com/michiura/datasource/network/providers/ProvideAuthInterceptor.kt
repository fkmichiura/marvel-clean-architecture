package com.michiura.datasource.network.providers

import com.michiura.data.BuildConfig
import com.michiura.datasource.commons.Constants.MD5_HASH_QUERY_PARAM
import com.michiura.datasource.commons.Constants.PUBLIC_API_KEY_QUERY_PARAM
import com.michiura.datasource.commons.Constants.TIMPESTAMP_QUERY_PARAM
import com.michiura.datasource.network.extensions.getMd5Digest
import com.michiura.datasource.network.extensions.timestamp
import okhttp3.Interceptor
import okhttp3.Response
import java.util.Date

class ProvideAuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        val url = request
            .url()
            .newBuilder()
            .addQueryParameter(TIMPESTAMP_QUERY_PARAM, Date().timestamp)
            .addQueryParameter(PUBLIC_API_KEY_QUERY_PARAM, BuildConfig.PUBLIC_API_KEY)
            .addQueryParameter(MD5_HASH_QUERY_PARAM, HASH.getMd5Digest)
            .build()

        return chain.proceed(
            request
                .newBuilder()
                .url(url)
                .build()
        )
    }

    companion object {
        private var HASH: String =
            Date().timestamp + BuildConfig.PRIVATE_API_KEY + BuildConfig.PUBLIC_API_KEY
    }
}
