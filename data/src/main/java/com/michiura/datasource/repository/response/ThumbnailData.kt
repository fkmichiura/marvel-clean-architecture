package com.michiura.data.repository.response

import com.google.gson.annotations.SerializedName

class ThumbnailData(

    @SerializedName("path")
    val thumbnailPath: String,

    @SerializedName("extension")
    val thumbnailExtension: String
)
