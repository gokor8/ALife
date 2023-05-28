package com.alife.anotherlife.ui.screen.main.finish_create_alife

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction

abstract class BaseCreateFinishScreen<VM : BaseCreateFinishViewModel<*, *, *>>(
    override val navController: NavController
) : VMScreenLCE<VM>(SystemPaddingModifier) {

    override suspend fun onInit() {
        viewModel.reduceFinishAction(BaseFinishAction.Init())
    }

    @Composable
    override fun SafeContent(modifier: Modifier) {
        Box(modifier) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextBase(
                        textResId = R.string.horizontal_short_logo,
                        style = Title28Style().style()
                    )
                }
                Spacer(modifier = Modifier.padding(bottom = 22.dp))

                InnerContent(Modifier.aspectRatio(328/480f))

                Spacer(modifier = Modifier.padding(bottom = 80.dp))
            }

            FloatingActionButton(onClick = {
                viewModel.reduceFinishAction(BaseFinishAction.Download())
            }, modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomCenter)) {
                TextBase(
                    R.string.upload,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }
        }
    }

    @Composable
    protected abstract fun InnerContent(modifier: Modifier)
}