package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.addons.ContextMainThreadWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraCircleComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.EmptyCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.NotScrollablePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import java.lang.ref.WeakReference

@Stable
interface PicturePagerItem : CreateAlifePagerItem {

    abstract class TakePicture<C : BaseCaptureWrapper>(
        protected val captureWrapper: C,
        private val isEnabled: Boolean
    ) : CreateAlifePagerItem.Abstract(), PicturePagerItem {

        @Composable
        override fun Content(
            size: Dp,
            viewModel: CreateAlifeViewModel
        ) {
            val colorScheme = MaterialTheme.colorScheme
            val context = LocalContext.current

            CameraCircleComposable(
                colorScheme.onPrimary,
                pagerItemSize.sizeDp(),
                isEnabled
            ) {
                onClick(
                    viewModel,
                    ContextMainThreadWrapper(WeakReference(context))
                )
            }
        }

        protected abstract fun onClick(
            viewModel: CreateAlifeViewModel,
            context: BaseContextMainExecutorWrapper
        )
    }

    class InitTakePicture : TakePicture<EmptyCaptureWrapper>(EmptyCaptureWrapper(), false) {
        override fun onClick(
            viewModel: CreateAlifeViewModel,
            context: BaseContextMainExecutorWrapper
        ) = Unit
    }

    class DefaultTakePicture(
        captureWrapper: CookedCaptureWrapper
    ) : TakePicture<CookedCaptureWrapper>(captureWrapper, true), InvertiblePagerItem {
        override fun onClick(
            viewModel: CreateAlifeViewModel,
            context: BaseContextMainExecutorWrapper
        ) {
            viewModel.reduce(CreateAlifeAction.CreatePhoto(context, captureWrapper))
        }
    }

    class OnPictureTaking : CreateAlifePagerItem.Abstract(), PicturePagerItem,
        NotScrollablePagerItem {

        @Composable
        override fun Content(
            size: Dp,
            viewModel: CreateAlifeViewModel
        ) {
            CircularProgressIndicator(
                strokeWidth = 2.dp,
                modifier = Modifier.size(pagerItemSize.sizeDp())
            )
        }
    }
}