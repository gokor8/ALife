package com.alife.anotherlife.di.ui.login

import com.alife.anotherlife.core.navigation.nav_navigator.BaseNavigator
import com.alife.anotherlife.ui.screen.login.mapper.*
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseDefaultAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseMockAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseUIAuthToColumnUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.container.LoginAuthTypeToContainerUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.container.MockUIAuthToColumnContainer
import com.alife.core.mapper.ListMapper
import com.alife.core.mapper.Mapper
import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.login.content.entity.AuthTypeEntity
import com.alife.domain.login.registration_stage.ThrowToRegStageEntity
import com.alife.domain.registration.core.entity.BoxRegEntity
import com.alife.domain.registration.usecase.base.entity.ReadBoxRegEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface LoginMapperModule {

    @Binds
    fun mockEmptyUIAuthToColumnUIAuth(mapper: MockUIAuthToColumnContainer): BaseUIAuthToColumnUIAuth

    @Binds
    fun loginAuthTypeToUIAuth(mapper: LoginAuthTypeToContainerUIAuth): BaseLoginAuthTypeToUIAuth

    @Binds
    fun loginSliceListMapper(mapper: LoginSliceListMapper): ListMapper<AuthTypeEntity>

    @Binds
    fun listAuthTypeToUIAuth(mapper: ListAuthTypeToUIAuth): BaseListAuthTypeToUIAuth

    @Binds
    fun defaultAuthTypeToUIAuth(mapper: DefaultAuthTypeToUIAuth): BaseDefaultAuthTypeToUIAuth

    @Binds
    fun mockAuthTypeToUIAuth(mapper: MockAuthTypeToUIAuth): BaseMockAuthTypeToUIAuth

    @Binds
    fun bindBoxRegEntityToNavigator(
        mapper: BoxRegEntityToNavigator
    ): Mapper<ReadBoxRegEntity<*>, BaseNavigator>
}