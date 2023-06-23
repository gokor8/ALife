package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile

import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.core.ui.view_model.BaseViewModelLCE
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.BaseHomeReducerBase
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.state.PostState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostProfileViewModel @Inject constructor(
    override val reducerVM: BasePostProfileReducer
) : ViewModelLCE<BasePostProfileReducer, PostAction, PostState, PostEffect>(reducerVM)