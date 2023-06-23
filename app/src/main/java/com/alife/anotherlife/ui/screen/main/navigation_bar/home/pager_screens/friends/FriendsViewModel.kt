package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FriendsViewModel @Inject constructor(
    reducer: FriendsReducer
) : AbstractHomeChildViewModel(reducer)