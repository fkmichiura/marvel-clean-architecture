package com.michiura.datasource.network.providers

import com.michiura.datasource.commons.constants.Constants
import com.michiura.datasource.commons.constants.Constants.API_KEY_QUERY_PARAM
import com.michiura.datasource.commons.constants.Constants.MD5_HASH_QUERY_PARAM
import com.michiura.datasource.commons.constants.Constants.PUBLIC_API_KEY
import com.michiura.datasource.commons.constants.Constants.TIMPESTAMP_QUERY_PARAM
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
            .addQueryParameter(API_KEY_QUERY_PARAM, PUBLIC_API_KEY)
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
        private var HASH: String = Date().timestamp + Constants.PRIVATE_API_KEY + PUBLIC_API_KEY
    }
}