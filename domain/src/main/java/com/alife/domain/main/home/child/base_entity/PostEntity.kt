package com.alife.domain.main.home.child.base_entity

import java.util.Date

interface PostEntity {

    abstract class Abstract {
        abstract val username: String
        abstract val creationDate: Date
    }
}

class VideoPostEntity(
    override val username: String,
    override val creationDate: Date,
    val video: String,
) : PostEntity.Abstract()

class ImagePostEntity(
    override val username: String,
    override val creationDate: Date,
    val firstPhoto: String,
    val secondPhoto: String,
) : PostEntity.Abstract()

class BadPostEntity(
    override val username: String,
    override val creationDate: Date
) : PostEntity.Abstract()