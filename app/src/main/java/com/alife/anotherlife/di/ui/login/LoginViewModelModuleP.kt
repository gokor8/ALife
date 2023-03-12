package com.alife.anotherlife.di.ui.login

import com.alife.anotherlife.core.ui.store.DefaultUIStore
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.login.state.LoginEffect
import com.alife.anotherlife.ui.screen.login.state.LoginState
import com.alife.domain.login.registration_stage.ListRegStageUseCase
import com.alife.domain.registration.usecase.birthday.BirthdayReadRegStageUseCase
import com.alife.domain.registration.usecase.email.save_read.EmailReadRegStageUseCase
import com.alife.domain.registration.usecase.name.NameReadRegStageUseCase
import com.alife.domain.registration.usecase.username.UsernameReadRegStageUseCase
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
        nameReadRegStageUseCase: NameReadRegStageUseCase,
        usernameReadRegStageUseCase: UsernameReadRegStageUseCase,
        birthdayReadRegStageUseCase: BirthdayReadRegStageUseCase,
        emailReadRegStageUseCase: EmailReadRegStageUseCase,
    ): ListRegStageUseCase {
        return ListRegStageUseCase(
            nameReadRegStageUseCase,
            usernameReadRegStageUseCase,
            birthdayReadRegStageUseCase,
            emailReadRegStageUseCase
        )
    }
}