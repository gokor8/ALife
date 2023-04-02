package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.composable.modifier.ImeModifier
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.rotate.Rotate
import com.alife.anotherlife.ui.screen.main.create_alife.model.rotate.RotateZero
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class CreateAlifeScreen(
    override val navController: NavController,
) : VMScreen<CreateAlifeViewModel>(ImeModifier()) {

    @Composable
    override fun setupViewModel(): CreateAlifeViewModel = hiltViewModel()

    @OptIn(ExperimentalPermissionsApi::class, ExperimentalPagerApi::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val cameraPermission = viewModel.cameraPermission.requirePermission { permissionState ->
            when (permissionState) {
                is PermissionStatus.Success -> {
                    viewModel.reduce(CreateAlifeAction.PermissionGrantedAction())
                }
                is PermissionStatus.Fatal -> {
                    viewModel.reduce(CreateAlifeAction.PermissionFatalAction())
                }
            }
        }

        val state = viewModel.getUIState()

        var rememberCameraSelector by remember {
            mutableStateOf(CameraSelector.DEFAULT_FRONT_CAMERA)
        }

        val screenState = state.screenState

        // Одно и тоже состояние тригеррится 2 раза
        if (screenState is CameraScreenState) {

            // Одно и тоже состояние тригеррится 2 раза
            key(screenState) {
                val cameraFacade = CameraSetupFactory().create(screenState.cameraSelector)

                CameraPreviewComposable(
                    cameraFacade,
                    modifier = Modifier.fillMaxSize()
                ) {
                    // viewModel set captureWrapper
                }
            }
        }

        state.screenState.Content(cameraPermission, viewModel, modifier)

        Column(
            horizontalAlignment = CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            val pagerContent = listOf(CameraPagerItem(), VideoPagerItem())

            Spacer(modifier = Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 62.dp)
            ) {
                HorizontalPager(count = pagerContent.size, modifier = Modifier.width(96.dp)) {
                    pagerContent[it].Content()
                }

                var rotationState by remember { mutableStateOf<Rotate>(RotateZero()) }

                val rotationAnim by animateFloatAsState(rotationState.rotation())

                ImageBase(
                    resId = R.drawable.ic_camera_change,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(4.dp)
                        .rotate(rotationAnim)
                        .clickableNoRipple {
                            rotationState = rotationState.nextRotate()
                            rememberCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
                            viewModel.reduce(CreateAlifeAction.ChangeCameraSelection())
                        }
                )
            }
        }
    }
}

interface PagerItem {

    @Composable
    fun Content()
}

class CameraPagerItem : PagerItem {

    @Composable
    override fun Content() {
        val colorScheme = MaterialTheme.colorScheme

        Canvas(modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .clickable { }
        ) {
            drawCircle(color = colorScheme.onPrimary, radius = 60f, style = Stroke(6f))
        }
    }
}

class VideoPagerItem : PagerItem {

    @Composable
    override fun Content() {

    }
}