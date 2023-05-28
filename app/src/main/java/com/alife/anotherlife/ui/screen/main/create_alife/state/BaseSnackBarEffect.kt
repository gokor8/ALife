package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.core.composable.snackbar.OnlyTextSnackBar
import com.alife.domain.core.delay.DelayWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface BaseSnackBarEffect {

    suspend fun showSnackBar(snackBarVisibility: MutableState<BaseSnackBarEffect>) = Unit

    @Composable
    fun ShowSnackBar(modifier: Modifier) = Unit


    class Empty : BaseSnackBarEffect

    abstract class Abstract(
        @StringRes private val text: Int
    ) : BaseSnackBarEffect {
        override suspend fun showSnackBar(snackBarVisibility: MutableState<BaseSnackBarEffect>) {
            snackBarVisibility.value = this
            DelayWrapper.Medium().delay()
            snackBarVisibility.value = Empty()
        }

        @Composable
        override fun ShowSnackBar(modifier: Modifier) {
            OnlyTextSnackBar(stringResource(text), modifier = modifier)
        }
    }
}