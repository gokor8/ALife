package com.alife.anotherlife.ui.screen.main.post_detail.state

import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.post_detail.model.BaseUIPostDetail

data class PostDetailState(
    override val lceModel: LCEModel = LCELoading,
    val uiPostDetail: BaseUIPostDetail = BaseUIPostDetail.Empty()
) : StateLCE