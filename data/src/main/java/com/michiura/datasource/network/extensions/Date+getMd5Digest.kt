package com.michiura.datasource.network.extensions

import com.michiura.datasource.commons.Constants.MD5
import com.michiura.datasource.commons.Constants.MESSAGE_DIGEST_ALGORITHM
import java.math.BigInteger
import java.security.MessageDigest

val String.getMd5Digest: String
    get() = BigInteger(
        MD5.DIGEST_SIGN,
        MessageDigest.getInstance(MESSAGE_DIGEST_ALGORITHM).digest(this.toByteArray())
    ).toString(MD5.DIGEST_RADIX).padStart(
        MD5.DIGEST_PAD_START_LENGTH,
        MD5.DIGEST_PAD_START_CHAR
    )
