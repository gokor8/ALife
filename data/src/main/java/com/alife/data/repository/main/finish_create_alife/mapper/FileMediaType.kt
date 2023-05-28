package com.alife.data.repository.main.finish_create_alife.mapper

import okhttp3.MediaType

interface FileMediaType {

    fun mediaType(): String

    fun mediaTypeParsed(): MediaType? = MediaType.parse(mediaType())


    class Image : FileMediaType {
        override fun mediaType() = "image/*"
    }

    class Video : FileMediaType {
        override fun mediaType() = "video/*"
    }
}