package com.alife.anotherlife.core.composable.map.listeners

import com.mapbox.maps.plugin.locationcomponent.LocationComponentPlugin
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorBearingChangedListener
import com.mapbox.maps.plugin.locationcomponent.OnIndicatorPositionChangedListener

interface AddRemoveLocationChangedListener : AddRemoveMapListener<LocationComponentPlugin> {

    class Position(
        private val indicatorPositionChangedListener: OnIndicatorPositionChangedListener
    ) : AddRemoveLocationChangedListener {

        override fun addListener(location: LocationComponentPlugin) {
            location.addOnIndicatorPositionChangedListener(indicatorPositionChangedListener)
        }

        override fun removeListener(location: LocationComponentPlugin) {
            location.removeOnIndicatorPositionChangedListener(indicatorPositionChangedListener)
        }
    }

    class Bearing(
        private val indicatorBearingChangedListener: OnIndicatorBearingChangedListener
    ) : AddRemoveLocationChangedListener {

        override fun addListener(location: LocationComponentPlugin) {
            location.addOnIndicatorBearingChangedListener(indicatorBearingChangedListener)
        }

        override fun removeListener(location: LocationComponentPlugin) {
            location.removeOnIndicatorBearingChangedListener(indicatorBearingChangedListener)
        }
    }
}