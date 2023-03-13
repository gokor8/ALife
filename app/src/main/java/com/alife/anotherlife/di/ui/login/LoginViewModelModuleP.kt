package com.alife.anotherlife.di.ui.login

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.state.LoginEffect
import com.alife.anotherlife.ui.screen.login.state.LoginState
import com.alife.domain.login.registration_stage.ListRegStageUseCase
import com.alife.domain.registration.usecase.birthday.BirthdayReadRegStageUC
import com.alife.domain.registration.usecase.email.save_read.EmailReadRegStageUC
import com.alife.domain.registration.usecase.name.NameReadRegStageUC
import com.alife.domain.registration.usecase.username.UsernameReadRegStageUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class LoginViewModelModuleP {

    @Provides
    fun loginUIStore(): UIStore<LoginState, LoginEffect> = DefaultUIStore(LoginState())

    @Provides
    fun useCaseList(
        nameReadRegStageUC: NameReadRegStageUC,
        usernameReadRegStageUseCase: UsernameReadRegStageUC,
        birthdayReadRegStageUseCase: BirthdayReadRegStageUC,
        emailReadRegStageUseCase: EmailReadRegStageUC,
    ): ListRegStageUseCase {
        return ListRegStageUseCase(
            nameReadRegStageUC,
            usernameReadRegStageUseCase,
            birthdayReadRegStageUseCase,
            emailReadRegStageUseCase
        )
    }
}