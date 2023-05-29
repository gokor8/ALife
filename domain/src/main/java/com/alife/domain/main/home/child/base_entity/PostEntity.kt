package com.alife.domain.main.home.child.base_entity

import java.util.Date

interface PostEntity {

    abstract class Abstract : PostEntity {
        abstract val username: String
        abstract val creationDate: Date
        abstract val avatar: String?
    }
}

class VideoPostEntity(
    override val username: String,
    override val creationDate: Date,
    override val avatar: String?,
    val video: String,
) : PostEntity.Abstract()

class ImagePostEntity(
    override val username: String,
    override val creationDate: Date,
    override val avatar: String?,
    val firstPhoto: String,
    val secondPhoto: String,
) : PostEntity.Abstract()

class BadPostEntity(
    override val username: String,
    override val creationDate: Date,
    override val avatar: String?,
) : PostEntity.Abstract()