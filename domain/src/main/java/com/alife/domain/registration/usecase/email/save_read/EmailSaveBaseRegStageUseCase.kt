package com.alife.domain.registration.usecase.email.save_read

import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationSaveUseCaseBaseStage
import com.alife.domain.registration.usecase.email.save_read.entity.BoxEmailRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EmailSaveBaseRegStageUseCase @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher,
) : RegistrationSaveUseCaseBaseStage<BoxEmailRegEntity>(registrationRepository, dispatcher),
    BaseEmailUseCase.Save {

    override fun getSaveModel(inputData: String) = EmailSaveRegEntity(inputData)

}