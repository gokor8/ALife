package com.alife.anotherlife.ui.screen.main.navigation_bar.map.model

import android.app.ActionBar
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.load
import com.alife.anotherlife.core.composable.map.ResizeAnimation
import com.mapbox.geojson.Point

interface MapElementModel {

    val point: Point

    fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit)


    class Empty(override val point: Point = Point.fromLngLat(0.0, 0.0)) : MapElementModel {
        override fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit) = Unit
    }

    class Image(
        override val point: Point,
        private val imageUrl: String,
    ) : MapElementModel {

        private val size = SizeInvertiblePair(50f, 60f)

        override fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit) {
            val sizes = size.getPair(isSelected)

            val startSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                sizes.first,
                view.resources.displayMetrics
            )
            val finishSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                sizes.first,
                view.resources.displayMetrics
            )

            (view as? ImageView)?.also { imageView ->
                imageView.load(imageUrl)
                imageView.setOnClickListener {
//                    if (isSelected) {
//                        imageView.startAnimation(
//                            ResizeAnimation(imageView, finishSize, startSize)
//                        )
//                    } else {
//                        view.layoutParams =
//                            ViewGroup.LayoutParams(startSize.toInt(), startSize.toInt())
//                    }
                }
            }
        }
    }
}