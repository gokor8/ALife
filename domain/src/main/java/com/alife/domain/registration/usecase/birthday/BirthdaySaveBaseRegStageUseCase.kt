package com.alife.domain.registration.usecase.birthday

import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationSaveUseCaseBaseStage
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class BirthdaySaveBaseRegStageUseCase @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
) : RegistrationSaveUseCaseBaseStage<BirthdayRegEntity>(registrationRepository, dispatcher), BaseBirthdayUseCase.Save {

    override fun getSaveModel(inputData: String) = BirthdaySaveRegEntity(inputData)

}