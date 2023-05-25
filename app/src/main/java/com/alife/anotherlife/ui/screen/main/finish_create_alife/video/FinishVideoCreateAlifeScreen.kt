package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable

class FinishVideoCreateAlifeScreen : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) = Column {
        Card(modifier = modifier.padding(vertical = 30.dp, horizontal = 20.dp)) {
            // TODO Add Video Preview
            VideoPlayerComposable()
        }
    }
}