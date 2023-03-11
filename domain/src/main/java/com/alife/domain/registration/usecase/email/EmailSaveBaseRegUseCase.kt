package com.alife.domain.registration.usecase.email

import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationSaveUseCaseBase
import com.alife.domain.registration.usecase.email.entity.EmailRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EmailSaveBaseRegUseCase @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    override val dispatcher: CoroutineDispatcher,
) : RegistrationSaveUseCaseBase<EmailRegEntity>(registrationRepository, dispatcher),
    BaseEmailUseCase.Save {

    override fun getSaveModel(inputData: String) = EmailSaveRegEntity(inputData)

}