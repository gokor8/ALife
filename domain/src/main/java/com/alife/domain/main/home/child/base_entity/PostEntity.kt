package com.alife.domain.main.home.child.base_entity

import java.util.Date

interface PostEntity {
    val username: String
    val creationDate: Date
    val avatar: String?
}

class VideoPostEntity(
    override val username: String,
    override val creationDate: Date,
    override val avatar: String?,
    val video: String,
) : PostEntity

class ImagePostEntity(
    override val username: String,
    override val creationDate: Date,
    override val avatar: String?,
    val firstPhoto: String,
    val secondPhoto: String,
) : PostEntity

class BadPostEntity(
    override val username: String,
    override val creationDate: Date,
    override val avatar: String?,
) : PostEntity