package com.michiura.datasource.network.extensions

import com.michiura.datasource.commons.Constants.DATE_PATTERN
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

val Date.timestamp: String
    get() = SimpleDateFormat(
        DATE_PATTERN,
        Locale.getDefault()
    ).format(this)
