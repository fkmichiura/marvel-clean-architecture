package com.michiura.datasource.network.extensions

import com.michiura.datasource.commons.Constants.MD5_DIGEST_PAD_START_CHAR
import com.michiura.datasource.commons.Constants.MD5_DIGEST_PAD_START_LENGTH
import com.michiura.datasource.commons.Constants.MD5_DIGEST_RADIX
import com.michiura.datasource.commons.Constants.MD5_DIGEST_SIGN
import com.michiura.datasource.commons.Constants.MESSAGE_DIGEST_ALGORITHM
import java.math.BigInteger
import java.security.MessageDigest

val String.getMd5Digest: String
    get() = BigInteger(
        MD5_DIGEST_SIGN,
        MessageDigest.getInstance(MESSAGE_DIGEST_ALGORITHM).digest(this.toByteArray())
    ).toString(MD5_DIGEST_RADIX).padStart(
        MD5_DIGEST_PAD_START_LENGTH,
        MD5_DIGEST_PAD_START_CHAR
    )
