package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model

import androidx.media3.common.MediaItem
import androidx.media3.common.Player

class VideoPlayerListener : Player.Listener {

    override fun onEvents(
        player: Player,
        events: Player.Events
    ) {
        super.onEvents(player, events)
        // hide title only when player duration is at least 200ms
//        if (player.currentPosition >= 200)
//            visibleState.value = false
    }

    override fun onMediaItemTransition(
        mediaItem: MediaItem?,
        reason: Int
    ) {
        super.onMediaItemTransition(
            mediaItem,
            reason
        )
        // everytime the media item changes show the title
//        visibleState.value = true
//        videoTitle.value =
//            mediaItem?.mediaMetadata
//                ?.displayTitle.toString()
    }
}