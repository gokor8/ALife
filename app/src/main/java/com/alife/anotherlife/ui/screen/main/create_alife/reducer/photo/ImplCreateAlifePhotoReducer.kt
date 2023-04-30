package com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo

import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper

interface ImplCreateAlifePhotoReducer {

    suspend fun onCreatePhoto(contextWrapper: BaseContextMainExecutorWrapper)
}