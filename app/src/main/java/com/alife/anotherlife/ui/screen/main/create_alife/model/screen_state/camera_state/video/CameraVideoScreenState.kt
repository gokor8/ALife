package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSelectorInverter
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.InvertibleScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraPictureScreenState

class CameraVideoScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
    private val cameraInverter: CameraSelectorInverter = CameraSelectorInverter(cameraSelector)
) : CameraScreenState(cameraSelector), InvertibleScreenState {

    override fun copyInvertCamera(): CameraFirstScreenState {
        val invertCameraSelector = cameraInverter.invertCameraSelector()

        return CameraFirstScreenState(invertCameraSelector)
    }

    @Composable
    override fun TopRowContent(
        viewModel: CreateAlifeViewModel,
        modifier: Modifier
    ) {
        ConstraintLayout(modifier = modifier.fillMaxWidth()) {
            val (title, audio) = createRefs()

            TextBase(
                textResId = R.string.horizontal_short_logo,
                style = Title28Style().style(),
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )

            Switch(
                checked = false,
                onCheckedChange = {},
                thumbContent = {
                    IconBase(icon = R.drawable.ic_dialog_micro, Modifier.padding(6.dp))
                },
                modifier = Modifier.padding(24.dp).constrainAs(audio) {
                    top.linkTo(parent.top)
                    start.linkTo(title.end)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
    }
}