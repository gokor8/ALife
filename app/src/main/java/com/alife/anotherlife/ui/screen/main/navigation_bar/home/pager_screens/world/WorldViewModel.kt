package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorldViewModel @Inject constructor(
    reducer: WorldReducer
) : AbstractHomeChildViewModel(reducer)