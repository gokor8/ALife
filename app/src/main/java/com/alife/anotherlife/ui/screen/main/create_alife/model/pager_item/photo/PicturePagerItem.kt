package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.photo

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.addons.stable
import com.alife.anotherlife.core.composable.addons.stroke6Draw
import com.alife.anotherlife.core.composable.clickable
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.addons.ContextMainThreadWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraCircleComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CreateAlifePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.InvertiblePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.NotScrollablePagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import java.lang.ref.WeakReference

@Stable
interface PicturePagerItem : CreateAlifePagerItem {

    abstract class TakePicture(private val isEnabled: Boolean) : CreateAlifePagerItem.Abstract(),
        PicturePagerItem {

        @Composable
        override fun Content(
            size: Dp,
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            val colorScheme = MaterialTheme.colorScheme
            val context = LocalContext.current

            CameraCircleComposable(
                colorScheme.onPrimary,
                pagerItemSize.sizeDp(),
                isEnabled
            ) {
                viewModel.reduce(
                    CreateAlifeAction.CreatePhoto(
                        ContextMainThreadWrapper(WeakReference(context))
                    )
                )
            }
        }
    }

    class InitTakePicture : TakePicture(false)

    class DefaultTakePicture : TakePicture(true), InvertiblePagerItem

    class OnPictureTaking : CreateAlifePagerItem.Abstract(), PicturePagerItem,
        NotScrollablePagerItem {

        @Composable
        override fun Content(
            size: Dp,
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            CircularProgressIndicator(
                strokeWidth = 2.dp,
                modifier = Modifier.size(pagerItemSize.sizeDp())
            )
        }
    }
}