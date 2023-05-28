package com.michiura.datasource.commons

object Constants {
    const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm'Z'"
    const val MESSAGE_DIGEST_ALGORITHM = "MD5"

    const val TIMPESTAMP_QUERY_PARAM = "ts"
    const val PUBLIC_API_KEY_QUERY_PARAM = "apikey"
    const val MD5_HASH_QUERY_PARAM = "hash"

    const val MD5_DIGEST_SIGN = 1
    const val MD5_DIGEST_RADIX = 16
    const val MD5_DIGEST_PAD_START_LENGTH = 32
    const val MD5_DIGEST_PAD_START_CHAR = '0'
}
