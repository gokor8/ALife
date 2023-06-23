package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.style16Bold
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction

@Composable
fun BlurCreateAlife(
    modifier: Modifier = Modifier,
    onCreateAlife: (HomeChildAction.OnTakeALife) -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    Box(modifier = modifier) {
        content()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onBackground.copy(.98f))
                .padding(20.dp)
                .padding(horizontal = 40.dp)
        ) {
            TextBase(
                textResId = R.string.create_alife_on_post,
                textAlign = TextAlign.Center,
                style = style16Bold()
            )
            Spacer(modifier = Modifier.padding(bottom = 22.dp))
            Button18(text = R.string.create_alife_base) {
                onCreateAlife(HomeChildAction.OnTakeALife())
            }
        }
    }
}

@Preview
@Composable
fun PreviewBlurCreateAlfie() {
    BlurCreateAlife {
        Column(Modifier.background(Color.Black).fillMaxSize()) {}
    }
}