package com.alife.anotherlife.ui.screen.main.create_alife.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.rotate.Rotate
import com.alife.anotherlife.ui.screen.main.create_alife.model.rotate.RotateZero
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CameraActionsComposable(
    state: CreateAlifeState,
    viewModel: CreateAlifeViewModel,
    pagerItems: List<CreateAlifePagerItem>
) {
    val cameraActionModel = CameraActionModel()

    ConstraintLayout(
        CameraActionsConstraints().markup(cameraActionModel),
        modifier = Modifier.padding(16.dp)
    ) {
        HorizontalPager(
            count = pagerItems.size,
            reverseLayout = true,
            modifier = Modifier
                .layoutId(cameraActionModel.cameraActionsPager)
                .width(96.dp)
        ) {
            pagerItems[it].Content(
                state.captureWrapper,
                viewModel,
            )
        }

        var rotationState by remember { mutableStateOf<Rotate>(RotateZero()) }
        val rotationAnim by animateFloatAsState(rotationState.rotation())

        IconBase(
            icon = R.drawable.ic_camera_change,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .layoutId(cameraActionModel.invertCameraButton)
                .size(32.dp)
                .rotate(rotationAnim)
                .clickableNoRipple(enabled = state.canInvert()) {
                    rotationState = rotationState.nextRotate()
                    viewModel.reduce(CreateAlifeAction.ChangeCameraSelection())
                }
        )
    }
}