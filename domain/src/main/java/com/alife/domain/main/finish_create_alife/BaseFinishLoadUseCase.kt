package com.alife.domain.main.finish_create_alife

import com.alife.domain.main.create_alife.entity.PathEntity

interface BaseFinishLoadUseCase<M : PathEntity> {

    fun upload(pathEntity: M)
}