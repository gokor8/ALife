package com.alife.anotherlife.ui.main_nav_models

import com.alife.anotherlife.core.navigation.nav_factory.ArgsNavigationFactory

class TestNavFactory(
    testArgsContainerModel: TestArgsContainerModel
) : ArgsNavigationFactory<TestArgsContainerModel>(testArgsContainerModel) {

    override val routeTag: String = "user"
}