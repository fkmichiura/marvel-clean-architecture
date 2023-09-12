package com.michiura.datasource.commons

object Constants {
    const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm'Z'"
    const val MESSAGE_DIGEST_ALGORITHM = "MD5"

    const val TIMPESTAMP_QUERY_PARAM = "ts"
    const val PUBLIC_API_KEY_QUERY_PARAM = "apikey"

    object MD5 {
        const val HASH_QUERY_PARAM = "hash"

        const val DIGEST_SIGN = 1
        const val DIGEST_RADIX = 16
        const val DIGEST_PAD_START_LENGTH = 32
        const val DIGEST_PAD_START_CHAR = '0'
    }

    object Endpoints {
        const val CHARACTERS = "/v1/public/characters"
    }
}
