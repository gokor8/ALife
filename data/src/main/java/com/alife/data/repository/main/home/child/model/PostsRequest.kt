package com.alife.data.repository.main.home.child.model

import com.google.gson.annotations.SerializedName

class PostsRequest(
    @SerializedName("pageSize")
    val pageSize: Int = 10,
    @SerializedName("page")
    val page: Int
)