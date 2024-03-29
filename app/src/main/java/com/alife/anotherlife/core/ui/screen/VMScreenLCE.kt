package com.alife.anotherlife.core.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.modifier.ModifierProvider
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.view_model.BaseViewModelLCE
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.core.mapper.Mapper
abstract class VMScreenLCE<VM : BaseViewModelLCE<*, *, *, *>>(
    modifier: ModifierProvider = ScrollableModifier(),
    private val contentMapper: LceContentMapper = LceContentMapper.Default(),
) : VMScreen<VM>(modifier) {

    @Composable
    override fun SetupContent() {
        viewModel = setupViewModel()
        SetupLaunchEffect()
        super.SetupContent()
    }

    @Composable
    override fun Content(modifier: Modifier) {
        var lceModel = viewModel.getUIState().lceModel

        if(lceModel is LCEContent) {
            lceModel = object : LCEModel.Content {
                @Composable
                override fun LCEContent(modifier: Modifier) {
                    SafeContent(modifier)
                }
            }
        }

        LceStateMap(lceModel, modifier)
    }

    @Composable
    open fun LceStateMap(lceModel: LCEModel, modifier: Modifier) {
        contentMapper.Map(lceModel, modifier)
    }

    @Composable
    protected abstract fun SafeContent(modifier: Modifier)
}