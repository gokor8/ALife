package com.alife.anotherlife.ui.screen.registration.tutorial

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.modifier.ImeModifier
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.alife.anotherlife.R

class TutorialScreen : DefaultScreen(ImeModifier()) {

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    override fun Content(modifier: Modifier) {
        Column {
            val pages = listOf(
                FirstTutorialScreen(),
                SecondTutorialScreen(),
                ThirdTutorialScreen()
            )

            val pagerState = rememberPagerState()

            HorizontalPager(count = pages.size, state = pagerState) { index ->
                pages[index].SetupContent()
            }

            Row(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 44.dp)
            ) {
                repeat(pages.size) { index ->
                    val animationColor by animateColorAsState(
                        if (pagerState.currentPage == index) Color.Gray else Color.LightGray
                    )

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(78.dp, 8.dp)
                            .background(
                                animationColor,
                                MaterialTheme.shapes.medium
                            )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TutorialScreenPreview() {
    TutorialScreen().SetupContent()
}