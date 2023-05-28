package com.michiura.datasource.network.extensions

import com.michiura.datasource.commons.constants.Constants
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

val Date.timestamp: String
    get() = SimpleDateFormat(Constants.DATE_PATTERN, Locale.getDefault()).format(this)
