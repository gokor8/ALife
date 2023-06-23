package com.alife.domain.registration.usecase.reg_log.birthday

import com.alife.domain.registration.repository.BaseRegCacheRepository
import com.alife.domain.registration.usecase.base.RegistrationSaveRegStageUC
import com.alife.domain.registration.usecase.reg_log.birthday.entity.BirthdayRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class BirthdaySaveRegRegStageUC @Inject constructor(
    registrationRepository: BaseRegCacheRepository,
    dispatcher: CoroutineDispatcher,
) : RegistrationSaveRegStageUC<BirthdayRegEntity>(
    registrationRepository,
    dispatcher
), BaseBirthdayUseCase.Save {

    override fun getSaveModel(inputData: String) = BirthdaySaveCacheEntity(inputData)

}