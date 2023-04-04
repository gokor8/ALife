package com.alife.anotherlife.ui.screen.main.create_alife

import android.graphics.ColorFilter
import android.graphics.ColorMatrixColorFilter
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.clickable
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.composable.modifier.ImeModifier
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.UselessCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.rotate.Rotate
import com.alife.anotherlife.ui.screen.main.create_alife.model.rotate.RotateZero
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
                HorizontalPager(
                    count = pagerContent.size,
                    reverseLayout = true,
                    modifier = Modifier.width(96.dp)
                ) {
                    pagerContent[it].Content(
                        state.captureWrapper,
                        viewModel
                    )
                }

                var rotationState by remember { mutableStateOf<Rotate>(RotateZero()) }

                val rotationAnim by animateFloatAsState(rotationState.rotation())

                ImageBase(
                    resId = R.drawable.ic_camera_change,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(4.dp)
                        .background(MaterialTheme.colorScheme.primary)
                        .rotate(rotationAnim)
                        .clickableNoRipple(
                            enabled = state.captureWrapper !is UselessCaptureWrapper
                        ) {
                            rotationState = rotationState.nextRotate()
                            viewModel.reduce(CreateAlifeAction.ChangeCameraSelection())
                        }
                )
            }
        }
    }
}

interface PagerItem {

    @Composable
    fun Content(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    )
}

class CameraPagerItem : PagerItem {

    @Composable
    override fun Content(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        val colorScheme = MaterialTheme.colorScheme
        val context = LocalContext.current

        Canvas(modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .clickable(rememberCoroutineScope()) {
                val imageProxy = captureWrapper.takePhoto(context)
                viewModel.reduce(CreateAlifeAction.TakePhoto(imageProxy))
            }
        ) {
            drawCircle(color = colorScheme.primary, radius = 60f, style = Stroke(6f))
        }
    }
}

class VideoPagerItem : PagerItem {

    @Composable
    override fun Content(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        val colorScheme = MaterialTheme.colorScheme

        Canvas(modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .clickable(rememberCoroutineScope()) { }
        ) {
            drawCircle(color = colorScheme.primaryContainer, radius = 60f, style = Stroke(6f))
            drawCircle(color = colorScheme.primaryContainer, radius = 40f)
            drawCircle(color = colorScheme.onPrimaryContainer, 10f)
        }
    }
}