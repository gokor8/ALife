package com.alife.anotherlife.ui.screen.login

import com.alife.domain.login.registration_stage.BaseUserRegStageUseCase
import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity

class TestOnRegistrationLoginReducer {


}


// Fake Realization
class FakeUserRegStageUseCase : BaseUserRegStageUseCase {

    override suspend fun getStage(): ReadBoxRegEntity<*> {
        TODO("Not yet implemented")
    }
}