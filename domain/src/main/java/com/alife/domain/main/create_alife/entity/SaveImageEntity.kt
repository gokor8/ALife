package com.alife.domain.main.create_alife.entity

abstract class SaveImageEntity(val byteArray: ByteArray) {

    class FrontSaveImageEntity(imageByteArray: ByteArray) : SaveImageEntity(imageByteArray)

    class BackSaveImageEntity(imageByteArray: ByteArray) : SaveImageEntity(imageByteArray)
}