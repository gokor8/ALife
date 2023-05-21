package com.alife.anotherlife.di.ui.core

import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.DevNavigationGraph
import com.alife.anotherlife.ui.MainNavigationGraph
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavRoute
import dagger.Binds
import dagger.Module
import dagger.assisted.AssistedFactory
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavigationGraphModule {

    //@Binds
    //fun bindDevNavigationGraph(navigationGraph: DevNavigationGraph): NavigationGraph

    @Binds
    fun bindMainNavigationGraph(navigationGraph: MainNavigationGraph): NavigationGraph
}