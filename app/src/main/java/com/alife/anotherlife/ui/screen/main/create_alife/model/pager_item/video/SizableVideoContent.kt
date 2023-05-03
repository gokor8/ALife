package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.video

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.core.composable.addons.ClickableSuspendWrapper
import com.alife.anotherlife.core.composable.clickable
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.VideoCircleComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper

abstract class SizableVideoContent(
    private val size: Dp,
    private val clickableSuspendWrapper: ClickableSuspendWrapper
) {

    @Composable
    open fun Content(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        Log.d("Aboba Pager Item", "$this")

        MaterialTheme.colorScheme.apply {
            VideoCircleComposable(
                onPrimary,
                onPrimary,
                primary,
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape)
                    .clickableWrap { onClick(captureWrapper, viewModel) }
            )
        }
    }

    protected fun Modifier.clickableWrap(onClick: suspend () -> Unit): Modifier = composed {
        clickableSuspendWrapper.Clickable(modifier = this, onClick = onClick)
    }

    protected abstract suspend fun onClick(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    )

    override fun hashCode(): Int = 228
}