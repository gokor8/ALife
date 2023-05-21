package com.alife.domain.registration.usecase.name

import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationSaveRegStageUC
import com.alife.domain.registration.usecase.name.addons.NameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class NameSaveRegRegStageUC @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
) : RegistrationSaveRegStageUC<NameRegEntity>(registrationRepository, dispatcher),
    BaseNameUseCase.Save {

    override fun getSaveModel(inputData: String) = NameSaveCacheEntity(inputData)
}