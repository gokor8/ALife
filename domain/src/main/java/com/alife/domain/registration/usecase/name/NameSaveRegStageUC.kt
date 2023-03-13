package com.alife.domain.registration.usecase.name

import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationStageSaveUC
import com.alife.domain.registration.usecase.name.addons.NameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class NameSaveRegStageUC @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
) : RegistrationStageSaveUC<NameRegEntity>(registrationRepository, dispatcher),
    BaseNameUseCase.Save {

    override fun getSaveModel(inputData: String) = NameSaveRegEntity(inputData)
}