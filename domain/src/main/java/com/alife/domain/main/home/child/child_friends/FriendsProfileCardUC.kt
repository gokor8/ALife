package com.alife.domain.main.home.child.child_friends

import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.home.child.ProfileCardEntity
import com.alife.domain.main.home.child.ProfileCardUseCase
import com.alife.domain.main.home.child.ProfileUseCaseEntity
import com.alife.domain.main.home.child.mapper.BaseThrowToProfileEntity
import kotlinx.coroutines.CoroutineDispatcher
import java.util.Date
import javax.inject.Inject

class FriendsProfileCardUC @Inject constructor(
    dispatcher: CoroutineDispatcher,
    throwableMapper: BaseThrowToProfileEntity
) : ProfileCardUseCase(dispatcher, throwableMapper) {

    override suspend fun getProfileCards(): UseCaseResult<ProfileUseCaseEntity> {
        return withSafe {
            ProfileUseCaseEntity(
                List(6) {
                    val username = if(it % 2 == 0) "Vladuka_$it" else "Olegator_777_$it"

                    val avatar = if(it % 2 == 0) "https://random.imagecdn.app/500/150" else null

                    ProfileCardEntity(
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