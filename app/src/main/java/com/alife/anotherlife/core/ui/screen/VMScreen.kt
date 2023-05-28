package com.alife.anotherlife.core.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.ModifierProvider
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier
import com.alife.anotherlife.core.ui.view_model.AbstractViewModel

abstract class VMScreen<VM : AbstractViewModel<*, *, *>>(
    modifier: ModifierProvider = ScrollableModifier()
) : DefaultScreen(modifier) {

    protected lateinit var viewModel: VM

    protected abstract val navController: NavController


    @Composable
    abstract fun setupViewModel(): VM

    open suspend fun onInit() = Unit

    @Composable
    override fun SetupContent() {
        viewModel = setupViewModel()
        SetupLaunchEffect()
        super.SetupContent()
    }

    @Composable
    open fun SetupLaunchEffect() {
        LaunchedEffect(Unit) {
            onInit()
            setupEventCollector()
        }
    }

    open suspend fun setupEventCollector() {
        viewModel.collectEffect(navController)
    }
}