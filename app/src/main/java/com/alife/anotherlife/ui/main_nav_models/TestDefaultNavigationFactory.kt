package com.alife.anotherlife.ui.main_nav_models

import com.alife.anotherlife.core.navigation.nav_factory.DefaultNavigationFactory

class TestDefaultNavigationFactory : DefaultNavigationFactory() {

    override val routeTag: String = "user"

}