package com.alife.anotherlife.core.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.modifier.ModifierProvider
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.core.mapper.Mapper

abstract class VMScreenLCE<VM : ViewModelLCE<*, *, *>>(
    mapper: Mapper<LCEModel, Unit>, // TODO Add callback
    modifier: ModifierProvider = ScrollableModifier()
) : VMScreen<VM>(modifier) {

    @Composable
    override fun SetupContent() {
        viewModel = setupViewModel()
        SetupEffect()
        super.SetupContent()
    }

    @Composable
    override fun Content(modifier: Modifier) {
        mapper
    }

    protected abstract fun SafeContent(modifier: Modifier)
}