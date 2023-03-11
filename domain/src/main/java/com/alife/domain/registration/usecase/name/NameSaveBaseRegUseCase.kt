package com.alife.domain.registration.usecase.name

import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationSaveUseCaseBase
import com.alife.domain.registration.usecase.name.addons.NameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class NameSaveBaseRegUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher,
) : RegistrationSaveUseCaseBase<NameRegEntity>(registrationRepository, dispatcher),
    BaseNameUseCase.Save {

    override fun getSaveModel(inputData: String) = NameSaveRegEntity(inputData)
}