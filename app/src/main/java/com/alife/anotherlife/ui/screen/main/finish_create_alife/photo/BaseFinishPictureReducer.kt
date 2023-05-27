package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishReducer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state.FinishPictureState

interface BaseFinishPictureReducer : BaseVMReducer<FinishPictureState, FinishEffect>,
    BaseCreateFinishReducer<FinishPictureState>