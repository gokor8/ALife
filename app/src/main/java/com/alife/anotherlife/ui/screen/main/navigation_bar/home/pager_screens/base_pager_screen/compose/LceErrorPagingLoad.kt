package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.media3.exoplayer.ExoPlayer
import androidx.paging.compose.LazyPagingItems
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.BorderButton
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.style18Bold
import com.alife.anotherlife.core.composable.text.style.style36Bold
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer

object LceErrorPagingLoadProvider : LCEModel.Error {

    @Composable
    override fun LCEContent(modifier: Modifier) = Unit
}

class LceErrorPagingLoad : PagingLceError {

    @Composable
    override fun LCEContent(
        lazyPosts: LazyPagingItems<UIBasePostContainer>?,
        modifier: Modifier,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth().padding(horizontal = 30.dp)
        ) {
            TextBase(
                textResId = R.string.home_chile_paging_error_title,
                style = style18Bold(),
                textAlign = TextAlign.Center
            )
            Divider(Modifier.padding(vertical = 16.dp), thickness = 1.dp)
            BorderButton(textResId = R.string.repeat, onClick = { lazyPosts?.retry() })
        }
    }
}