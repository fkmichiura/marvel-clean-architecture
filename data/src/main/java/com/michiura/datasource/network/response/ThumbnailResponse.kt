package com.michiura.datasource.network.response

import com.google.gson.annotations.SerializedName

class ThumbnailResponse(
    @SerializedName("path")
    val path: String,

    @SerializedName("extension")
    val extension: String
)
