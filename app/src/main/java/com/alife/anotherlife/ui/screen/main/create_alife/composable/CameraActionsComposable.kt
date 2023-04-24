package com.alife.anotherlife.ui.screen.main.create_alife.composable

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.addons.ColorWrapper
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.rotate.Rotate
import com.alife.anotherlife.ui.screen.main.create_alife.model.rotate.RotateZero
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

@OptIn(ExperimentalFoundationApi::class)
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
        val currentPage = rememberPagerState(0)

        HorizontalPager(
            pageCount = pagerItems.size + 1,
            state = currentPage,
            pageSpacing = 18.dp,
            reverseLayout = true,
            pageSize = PageSize.Fixed(60.dp),
            modifier = Modifier.layoutId(cameraActionModel.cameraActionsPager)
        ) { page ->
            Log.d("Aboba", "currentoffsetFraction ${currentPage.currentPageOffsetFraction}")
            Log.d("Aboba", "currentPage ${currentPage.currentPage}")
            Log.d("Aboba", "targetPage ${currentPage.targetPage}")
            Log.d("Aboba", "settledPage ${currentPage.settledPage}")
            Log.d("Aboba", "sum ${currentPage.currentPageOffsetFraction + currentPage.currentPage}")

            val sizeMultiplier = currentPage.currentPageOffsetFraction + currentPage.currentPage

            Log.d("Aboba", "answer ${(28f * sizeMultiplier + 32f).dp}")

            if(page == pagerItems.size) Spacer(modifier = Modifier.padding(60.dp)) else
            pagerItems[page].Content(
                (28f * sizeMultiplier + 32f).dp,
                state.captureWrapper,
                viewModel,
                Modifier
            )
        }

        var rotationState by remember { mutableStateOf<Rotate>(RotateZero()) }
        val rotationAnim by animateFloatAsState(rotationState.rotation())
        val tintColor = if (state.canInvert()) ColorWrapper() else ColorWrapper(0.5f)

        IconBase(
            icon = R.drawable.ic_camera_change,
            tint = tintColor.color(MaterialTheme.colorScheme.onPrimary),
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