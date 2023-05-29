package com.alife.data.repository.main.home.child.model

import com.google.gson.annotations.SerializedName
import java.util.Date

class PostsResponse(
    @SerializedName("results")
    val results: List<PostResponse>
)

class PostResponse(
    @SerializedName("username")
    val username: String,
    @SerializedName("creationDate")
    val creationDate: Date,
    @SerializedName("firstPhoto")
    val firstPhoto: String?,
    @SerializedName("secondPhoto")
    val secondPhoto: String?,
    @SerializedName("video")
    val video: String?
)