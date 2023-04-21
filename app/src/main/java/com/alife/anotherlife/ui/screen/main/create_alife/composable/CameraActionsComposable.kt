package com.alife.anotherlife.ui.screen.main.create_alife.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
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
        val pagerSize = pagerItems.size + 1
        val currentPage = rememberPagerState(0)

        HorizontalPager(
            pageCount = pagerSize,
            state = currentPage,
            reverseLayout = true,
            pageSize = PageSize.Fixed(60.dp),
            pageSpacing = 32.dp,
            modifier = Modifier
                .layoutId(cameraActionModel.cameraActionsPager)
                .width(152.dp)
        ) { page ->
            val localPage = if(page == pagerSize - 1) page - 2 else page

            if (currentPage.currentPage != localPage)
                pagerItems[localPage].InactiveContent()
            else
                pagerItems[localPage].Content(
                    state.captureWrapper,
                    viewModel,
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