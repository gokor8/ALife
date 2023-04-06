package com.alife.domain.main.create_alife.entity

abstract class ReadImageEntity(val imageByteArray: ByteArray) {

    class FrontReadImageEntity(imageByteArray: ByteArray) : ReadImageEntity(imageByteArray)

    class BackReadImageEntity(imageByteArray: ByteArray) : ReadImageEntity(imageByteArray)
}