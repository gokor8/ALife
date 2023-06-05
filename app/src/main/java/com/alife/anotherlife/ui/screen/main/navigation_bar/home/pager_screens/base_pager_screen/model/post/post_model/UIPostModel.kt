package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.ExoPlayer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel

interface UIPostModel {

    fun itemKey(): String

    @Composable
    fun Card(
        exoPlayer: ExoPlayer,
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    )

    abstract class Abstract : UIPostModel {
        abstract val username: String
        abstract val timestamp: String
        abstract val avatar: String?

        override fun itemKey(): String = username + timestamp
    }

//    abstract class Default : Abstract() {
//
//        @Composable
//        abstract fun Card(viewModel: AbstractHomeChildViewModel, modifier: Modifier)
//    }
//
//    abstract class Video : Abstract() {
//
//        @Composable
//        abstract fun Card(
//            exoPlayer: ExoPlayer,
//            viewModel: AbstractHomeChildViewModel,
//            modifier: Modifier
//        )
//    }
}