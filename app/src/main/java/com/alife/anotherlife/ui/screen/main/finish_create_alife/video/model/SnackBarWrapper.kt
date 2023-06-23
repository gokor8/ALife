package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model

import androidx.annotation.StringRes
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch

abstract class SnackBarWrapper(@StringRes private val textRes: Int) {

    @Composable
    fun SnackBar(snackBarHostState: SnackbarHostState) {

        val text = stringResource(textRes)
        val coroutineScope = rememberCoroutineScope()

        LaunchedEffect(Unit) {
            coroutineScope.launch {
                snackBarHostState.showSnackbar(text)
            }
        }
    }
}