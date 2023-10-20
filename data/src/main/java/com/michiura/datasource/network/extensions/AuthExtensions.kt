package com.michiura.datasource.network.extensions

import com.michiura.data.BuildConfig
import com.michiura.datasource.commons.Constants
import java.math.BigInteger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object AuthExtensions {

    val getMd5Digest: String
        get() = BigInteger(
            Constants.MD5.DIGEST_SIGN,
            MessageDigest.getInstance(Constants.MESSAGE_DIGEST_ALGORITHM).digest(hash.toByteArray())
        ).toString(Constants.MD5.DIGEST_RADIX).padStart(
            Constants.MD5.DIGEST_PAD_START_LENGTH,
            Constants.MD5.DIGEST_PAD_START_CHAR
        )

    val Date.timestamp: String
        get() = SimpleDateFormat(
            Constants.DATE_PATTERN,
            Locale.getDefault()
        ).format(this)

    private val hash: String
        get() = Date().timestamp + BuildConfig.PRIVATE_API_KEY + BuildConfig.PUBLIC_API_KEY
}