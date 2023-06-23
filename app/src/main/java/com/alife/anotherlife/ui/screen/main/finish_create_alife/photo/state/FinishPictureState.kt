package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.state

import com.alife.anotherlife.core.ui.image.ImageExtModel
import com.alife.anotherlife.core.ui.state.lce.LCELoading
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.BaseLocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model.EmptyLocationModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state.FinishState
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.model.GeoImageExtModel
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.model.UILocalPicturesModel

data class FinishPictureState(
    override val lceModel: LCEModel = LCELoading,
    override val location: BaseLocationModel = EmptyLocationModel(),
    override val locationState: ImageExtModel = GeoImageExtModel(),
    val uiLocalPicturesModel: UILocalPicturesModel? = null
) : FinishState<FinishPictureState> {

    override fun copyLocationState(newLocationState: ImageExtModel) = copy(locationState = newLocationState)

    override fun copyLocation(newLocationModel: BaseLocationModel) = copy(location = newLocationModel)

    override fun copyLce(newLceModel: LCEModel) = copy(lceModel = newLceModel)
}