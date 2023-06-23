package com.alife.anotherlife.ui.screen.main.navigation_bar.map.state

import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.MapElementModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.UIMapPost

data class MapState(
    override val lceModel: LCEModel = LCELoading,
    val mapPosts: List<MapElementModel> = listOf(),
    val selected: MapElementModel = MapElementModel.Empty()
) : StateLCE