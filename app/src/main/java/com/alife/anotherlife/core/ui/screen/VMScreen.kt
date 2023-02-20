package com.alife.anotherlife.core.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.modifier.ModifierProvider
import com.alife.anotherlife.core.ui.view_model.BaseViewModel

abstract class VMScreen<VM : BaseViewModel<*, *, *>>(
    modifier: ModifierProvider
) : DefaultScreen(modifier) {

    protected lateinit var viewModel: VM

    protected abstract val navController: NavController


    @Composable
    abstract fun setupViewModel(): VM

    @Composable
    override fun SetupContent() {
        viewModel = setupViewModel()
        SetupEffect()
        super.SetupContent()
    }

    @Composable
    fun SetupEffect() {
        LaunchedEffect(true) {
            viewModel.collectEffect(navController)
        }
    }
}