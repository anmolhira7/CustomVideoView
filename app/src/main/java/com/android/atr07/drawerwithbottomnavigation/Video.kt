package com.android.atr07.drawerwithbottomnavigation

import android.net.Uri
import java.time.Duration

data class Video(
    val id: String,
    val title: String,
    val duration: Long = 0,
    val folderName: String,
    val size: String,
    val path: String,
    val artUri: Uri,
    val thumbnailUri:Uri
) {

    fun getVideoUri(): Uri? {
        return artUri
    }

}