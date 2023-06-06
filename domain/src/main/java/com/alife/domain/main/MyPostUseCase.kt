package com.alife.domain.main

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.main.home.child.BaseMainRepository
import kotlinx.coroutines.CoroutineDispatcher
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Named

class MyPostUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    //@Named("MockMainRepo")
    private val mainRepository: BaseMainRepository
) : AbstractUseCase(), BaseMyPostUseCase {

    private val defaultValue = true

    override suspend fun isHavePostToday() = withIO {
        try {
            mainRepository.isHavePostToday()
        } catch (e: Exception) {
            defaultValue
        }
    }
}