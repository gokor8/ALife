package com.alife.domain.main.home.child.child_world

import com.alife.domain.main.home.child.BaseProfileCardUseCase
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.ProfileUseCaseEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.Date
import javax.inject.Inject

interface BaseWorldProfileCardUC : BaseProfileCardUseCase

class WorldProfileCardUC @Inject constructor(
    private val dispatcher: CoroutineDispatcher
) : BaseWorldProfileCardUC {

    override suspend fun getProfileCards(): ProfileUseCaseEntity {
        return withContext(dispatcher) {
            ProfileUseCaseEntity(
                List(6) {
                    val username = if(it % 2 == 0) "Vladuka_$it" else "Olegator_777_$it"

                    val avatar = if(it % 2 == 0) "https://random.imagecdn.app/500/150" else null

                    ProfileCardEntity.Normal(
                        username,
                        "https://random.imagecdn.app/500/150",
                        "https://random.imagecdn.app/500/150",
                        Date(1000000L),
                        avatar
                    )
                }
            )
        }
    }
}