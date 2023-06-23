package com.alife.anotherlife.ui.screen.main.navigation_bar.profile

import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileAction
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileEffect
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.state.ProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    profileReducer: BaseProfileReducer
) : ViewModelLCE<BaseProfileReducer, ProfileAction, ProfileState, ProfileEffect>(profileReducer) {

    suspend fun collectEffect(navController: NavController, onSnackBar: (SnackBarWrapper) -> Unit) {
        reducerVM.getEffectCollector().collect { effect ->
            when(effect) {
                is SnackBarWrapper -> onSnackBar(effect)
                else -> onEffect(navController, effect)
            }
        }
    }
}