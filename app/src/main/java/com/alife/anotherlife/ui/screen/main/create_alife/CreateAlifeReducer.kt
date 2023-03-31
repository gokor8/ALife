package com.alife.anotherlife.ui.screen.main.create_alife

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class CreateAlifeReducer(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
) : BaseVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifeReducer {

}