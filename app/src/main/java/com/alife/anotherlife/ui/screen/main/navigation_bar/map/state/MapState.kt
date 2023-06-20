package com.alife.anotherlife.ui.screen.main.navigation_bar.map.state

import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.model.UIMapPost

data class MapState(
    override val lceModel: LCEModel = LCELoading,
    val mapPosts: List<UIMapPost> = listOf()
) : StateLCE