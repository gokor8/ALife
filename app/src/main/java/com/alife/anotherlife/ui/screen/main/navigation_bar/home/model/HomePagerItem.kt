package com.alife.anotherlife.ui.screen.main.navigation_bar.home.model

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.clickableNoRipple
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.ui.screen.Screen
import com.google.accompanist.pager.ExperimentalPagerApi

abstract class HomePagerItem(
    @StringRes private val titleId: Int,
) : BaseHomePagerItem {

    @Composable
    @ExperimentalPagerApi
    override fun TabContent(
        selected: Boolean,
        onClick: () -> Unit
    ) {
        TextBase(
            textResId = titleId,
            textAlign = TextAlign.Center,
            color = if (selected)
                Color.Unspecified
            else
                Color.Unspecified.copy(alpha = 0.5f),
            modifier = Modifier.padding(4.dp).clickableNoRipple(onClick = onClick)
        )
    }
}