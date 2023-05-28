package com.alife.domain.main.create_alife.picture.entity

import com.alife.domain.main.create_alife.entity.CreateAlifeReadEntity

interface ImageReadEntity : CreateAlifeReadEntity {

    class Front : ImageReadEntity

    class Back : ImageReadEntity
}