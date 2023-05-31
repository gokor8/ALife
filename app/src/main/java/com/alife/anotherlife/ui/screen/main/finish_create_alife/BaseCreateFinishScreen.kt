package com.alife.anotherlife.ui.screen.main.finish_create_alife

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import kotlinx.coroutines.launch

abstract class BaseCreateFinishScreen<VM : BaseCreateFinishViewModel<*, *, *>>(
    override val navController: NavController
) : VMScreenLCE<VM>(SystemPaddingModifier) {

    override suspend fun onInit() {
        viewModel.reduceFinishAction(BaseFinishAction.Init())
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun SafeContent(modifier: Modifier) {
        val snackbarHostState = remember { SnackbarHostState() }

        Scaffold(
            modifier,
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            innerPadding
            Box(Modifier.fillMaxSize()) {
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

                    InnerContent(Modifier.aspectRatio(328 / 480f))

                    Spacer(modifier = Modifier.padding(bottom = 80.dp))
                }

                FloatingActionButton(
                    onClick = {
                        viewModel.reduceFinishAction(BaseFinishAction.Download())
                    }, modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.BottomCenter)
                ) {
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

            var snackBarErrorEffect by remember {
                mutableStateOf<SnackBarWrapper?>(null)
            }.also { wrapper ->
                wrapper.value?.SnackBar(snackbarHostState)
            }

            LaunchedEffect(Unit) {
                viewModel.collectEffect(navController) { wrapper ->
                    snackBarErrorEffect = wrapper
                }
            }
        }
    }

    override suspend fun setupEventCollector() = Unit

    @Composable
    protected abstract fun InnerContent(modifier: Modifier)
}