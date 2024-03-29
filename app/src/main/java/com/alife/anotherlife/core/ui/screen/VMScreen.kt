package com.alife.anotherlife.core.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.ModifierProvider
import com.alife.anotherlife.core.composable.modifier.ScrollableModifier
import com.alife.anotherlife.core.ui.view_model.AbstractViewModel
import com.alife.anotherlife.core.ui.view_model.BaseViewModel

abstract class VMScreen<VM : BaseViewModel<*, *, *>>(
    modifier: ModifierProvider = ScrollableModifier()
) : DefaultScreen(modifier) {

    protected lateinit var viewModel: VM

    protected abstract val navController: NavController


    @Composable
    abstract fun setupViewModel(): VM

    @Composable
    open fun OnInitComposable() = Unit

    open suspend fun onInit() = Unit

    @Composable
    override fun SetupContent() {
        viewModel = setupViewModel()
        SetupLaunchEffect()
        OnInitComposable()
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