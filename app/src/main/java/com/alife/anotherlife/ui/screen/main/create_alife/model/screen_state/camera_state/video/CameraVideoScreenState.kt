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
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.CameraScreenState

class CameraVideoScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA
) : CameraScreenState(cameraSelector) {

    @Composable
    override fun TopRowContent(
        viewModel: CreateAlifeViewModel,
        modifier: Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(2f))
            TextBase(
                textResId = R.string.horizontal_short_logo,
                style = Title28Style().style(),
                modifier = Modifier.padding(top = 22.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

            Switch(
                checked = false,
                onCheckedChange = {},
                thumbContent = {
                    IconBase(icon = R.drawable.ic_dialog_micro)
                },
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}