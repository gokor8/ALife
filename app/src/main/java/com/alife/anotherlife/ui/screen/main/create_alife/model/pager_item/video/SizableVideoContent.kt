package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

import android.content.Context
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.core.composable.addons.ClickableSuspendWrapper
import com.alife.anotherlife.core.composable.addons.ColorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.VideoCircleComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper

abstract class SizableVideoContent(
    private val isEnabled: Boolean,
    private val size: Dp,
    private val clickableSuspendWrapper: ClickableSuspendWrapper
) {

    @Composable
    open fun Content(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        val context = LocalContext.current
        val color = if (isEnabled) ColorWrapper() else ColorWrapper(0.5f)

        MaterialTheme.colorScheme.apply {
            VideoCircleComposable(
                color.color(onPrimary),
                color.color(onPrimary),
                color.color(primary),
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape)
                    .clickableWrap(isEnabled) {
                        onClick(context,captureWrapper, viewModel)
                    }
            )
        }
    }

    protected fun Modifier.clickableWrap(
        isEnabled: Boolean,
        onClick: suspend () -> Unit
    ): Modifier = composed {
        clickableSuspendWrapper.Clickable(modifier = this, isEnabled, onClick = onClick)
    }

    protected abstract suspend fun onClick(
        context: Context,
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    )
}