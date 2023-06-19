package com.alife.anotherlife.ui.screen.main.finish_create_alife

import android.annotation.SuppressLint
import android.content.Context
import android.location.LocationManager
import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.getSystemService
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.ui.screen.main.create_alife.model.audio.BaseAudioActionModel
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.EmptyLocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.BaseFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.SnackBarWrapper
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.launch

abstract class BaseCreateFinishScreen<VM : BaseCreateFinishViewModel<*, *, *>>(
    override val navController: NavController
) : VMScreenLCE<VM>(SystemPaddingModifier) {

    override suspend fun onInit() {
        viewModel.reduceFinishAction(BaseFinishAction.Init())
    }

    @SuppressLint("MissingPermission")
    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun SafeContent(modifier: Modifier) {
        val snackBarHostState = remember { SnackbarHostState() }

        val locationPermission = viewModel.location.requirePermission(viewModel)

        Scaffold(
            modifier,
            snackbarHost = { SnackbarHost(snackBarHostState) }
        ) { innerPadding ->
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
                        Spacer(
                            Modifier
                                .padding(start = 8.dp)
                                .weight(1f)
                        )
                        Switch(
                            checked = viewModel.getUIState().location !is EmptyLocationModel,
                            onCheckedChange = {
                                Log.d("Aboba switch", "on click switch")
                                locationPermission.launchPermissionRequest()
                            },
                            thumbContent = {
                                IconBase(icon = R.drawable.ic_gps, Modifier.padding(6.dp))
                            },
                            colors = SwitchDefaults.colors(
                                uncheckedTrackColor = Color.Transparent,
                                checkedBorderColor = Color.Transparent,
                                disabledCheckedBorderColor = Color.Transparent,
                                disabledUncheckedBorderColor = Color.Transparent
                            )
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
                wrapper.value?.SnackBar(snackBarHostState)
            }

            val context = LocalContext.current

            LaunchedEffect(Unit) {
                viewModel.collectEffect(
                    navController,
                    onSnackBarError = { wrapper -> snackBarErrorEffect = wrapper },
                    onLocation = {
                        context.getSystemService<LocationManager>()
                            ?.getLastKnownLocation(LocationManager.GPS_PROVIDER)?.apply {
                            viewModel.reduceFinishAction(BaseFinishAction.Location(longitude, latitude))
                        }
                    }
                )
            }
        }
    }

    override suspend fun setupEventCollector() = Unit

    @Composable
    protected abstract fun InnerContent(modifier: Modifier)
}