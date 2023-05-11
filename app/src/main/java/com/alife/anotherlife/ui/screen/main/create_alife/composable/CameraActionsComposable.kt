package com.alife.anotherlife.ui.screen.main.create_alife.composable

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.layoutId
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
    pagerState: PagerState,
    pagerItems: List<CreateAlifePagerItem>,
    modifier: Modifier = Modifier
) {
    val cameraActionModel = CameraActionModel()

    ConstraintLayout(
        CameraActionsConstraints().markup(cameraActionModel),
        modifier = modifier.padding(16.dp)
    ) {
        val pageSpacing = 18.dp
        val pageSize = 60.dp
        val fullPageSize = pageSize + pageSpacing

        HorizontalPager(
            pageCount = pagerItems.size,
            state = pagerState,
            reverseLayout = true,
            userScrollEnabled = state.canPagerItemScroll(),
            pageSpacing = pageSpacing,
            pageSize = PageSize.Fixed(pageSize),
            modifier = Modifier
                .layoutId(cameraActionModel.cameraActionsPager)
                .width(pageSize + fullPageSize)
        ) { page ->
            val minPageSize = 32f
            val sizeMultiplier = pagerState.currentPageOffsetFraction + pagerState.currentPage
            val calculatedSize = ((pageSize.value - minPageSize) * sizeMultiplier + minPageSize).dp

            Log.e("Aboba", "${pagerState.currentPage}")
            Log.e("Aboba Page", "${pagerItems[page]}")

            pagerItems[page].Content(
                // 28f * ... + 32f
                calculatedSize,
                viewModel,
            )
        }

        var rotationState by remember { mutableStateOf<Rotate>(RotateZero()) }
        val rotationAnim by animateFloatAsState(rotationState.rotation())

        val canInvert = state.currentScreenPager().canInvert()
        val tintColor = if (canInvert) ColorWrapper() else ColorWrapper(0.5f)

        IconBase(
            icon = R.drawable.ic_camera_change,
            tint = tintColor.color(MaterialTheme.colorScheme.onPrimary),
            modifier = Modifier
                .layoutId(cameraActionModel.invertCameraButton)
                .size(32.dp)
                .rotate(rotationAnim)
                .clickableNoRipple(enabled = canInvert) {
                    rotationState = rotationState.nextRotate()
                    viewModel.reduce(CreateAlifeAction.ChangeCameraSelection())
                }
        )
    }
}