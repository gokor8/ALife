package com.alife.domain.registration.usecase.reg_log.name

import com.alife.domain.registration.repository.BaseRegCacheRepository
import com.alife.domain.registration.usecase.base.RegistrationSaveRegStageUC
import com.alife.domain.registration.usecase.reg_log.name.addons.NameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class NameSaveRegRegStageUC @Inject constructor(
    registrationRepository: BaseRegCacheRepository,
    dispatcher: CoroutineDispatcher,
) : RegistrationSaveRegStageUC<NameRegEntity>(registrationRepository, dispatcher),
    BaseNameUseCase.Save {

    override fun getSaveModel(inputData: String) = NameSaveCacheEntity(inputData)
}