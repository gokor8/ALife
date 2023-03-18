package com.alife.domain.registration.usecase.email.save_read

import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationSaveRegStageUC
import com.alife.domain.registration.usecase.email.save_read.entity.EmailRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EmailSaveRegRegStageUC @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher,
) : RegistrationSaveRegStageUC<EmailRegEntity>(registrationRepository, dispatcher),
    BaseEmailUseCase.Save {

    override fun getSaveModel(inputData: String) = EmailSaveRegEntity(inputData)

}