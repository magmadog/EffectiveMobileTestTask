package com.sarbaevartur.data.data.storage.models

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

data class LoadedImage(
    val drawable: Drawable? = null,
    var bitmap: Bitmap? = null
)