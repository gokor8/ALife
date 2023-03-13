package com.alife.domain.login.registration_stage

import com.alife.domain.registration.usecase.base.BaseRegStageUseCase
import javax.inject.Inject

class ListRegStageUseCase(
    vararg regStageUseCase: BaseRegStageUseCase.ReadBox<*>
) : ArrayList<BaseRegStageUseCase.ReadBox<*>>(regStageUseCase.toList())