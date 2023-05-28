package com.alife.domain.main.finish_create_alife

interface BaseFinishLoadUseCase {

    suspend fun upload()


    abstract class Abstract(protected val repository: BaseFinishAlifeRepository) : BaseFinishLoadUseCase
}