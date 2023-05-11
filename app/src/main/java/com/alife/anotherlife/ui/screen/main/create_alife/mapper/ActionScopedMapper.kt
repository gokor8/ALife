package com.alife.anotherlife.ui.screen.main.create_alife.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class ActionScopedMapper @Inject constructor() : BaseActionScopedMapper {
    override fun map(action: CreateAlifeAction, viewModelScope: CoroutineScope) =
        if (action is CreateAlifeAction.CreatePhoto)
            CreateAlifeAction.CreatePhotoScoped(
                viewModelScope,
                action.contextWrapper,
                action.cookedCaptureWrapper
            )
        else action
}