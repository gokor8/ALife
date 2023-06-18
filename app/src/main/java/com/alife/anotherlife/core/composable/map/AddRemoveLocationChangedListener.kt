package com.alife.anotherlife.core.composable.map

import com.mapbox.maps.plugin.locationcomponent.LocationComponentPlugin
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorBearingChangedListener
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorPositionChangedListener

interface AddRemoveLocationChangedListener {

    fun addOnIndicatorListener(location: LocationComponentPlugin)

    fun removeOnIndicatorListener(location: LocationComponentPlugin)


    class Position(
        private val indicatorPositionChangedListener: OnIndicatorPositionChangedListener
    ) : AddRemoveLocationChangedListener {

        override fun addOnIndicatorListener(location: LocationComponentPlugin) {
            location.addOnIndicatorPositionChangedListener(indicatorPositionChangedListener)
        }

        override fun removeOnIndicatorListener(location: LocationComponentPlugin) {
            location.removeOnIndicatorPositionChangedListener(indicatorPositionChangedListener)
        }
    }

    class Bearing(
        private val indicatorBearingChangedListener: OnIndicatorBearingChangedListener
    ) : AddRemoveLocationChangedListener {

        override fun addOnIndicatorListener(location: LocationComponentPlugin) {
            location.addOnIndicatorBearingChangedListener(indicatorBearingChangedListener)
        }

        override fun removeOnIndicatorListener(location: LocationComponentPlugin) {
            location.removeOnIndicatorBearingChangedListener(indicatorBearingChangedListener)
        }
    }
}