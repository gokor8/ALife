package com.alife.anotherlife.core.ui.screen

import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.composable.modifier.ModifierProvider
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier
import com.alife.anotherlife.core.ui.view_model.BaseViewModel

abstract class VMScreen<VM : BaseViewModel<*, *, *>>(modifier: ModifierProvider) :
    DefaultScreen(modifier) {

    protected lateinit var viewModel: VM

    @Composable
    abstract fun setupViewModel(): VM

    @Composable
    override fun SetupContent() {
        viewModel = setupViewModel()
        super.SetupContent()
    }
}