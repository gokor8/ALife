package com.alife.anotherlife.ui.screen.main.navigation_bar.map.model

import android.app.ActionBar
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.map.ResizeAnimation
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.mapbox.geojson.Point

interface MapElementModel {

    val point: Point


    fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit)


    abstract class Abstract(override val point: Point) : MapElementModel

    class Empty(
        point: Point = Point.fromLngLat(0.0, 0.0)
    ) : Abstract(point) {
        override fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit) = Unit
    }

    class Image(
        point: Point,
        private val imageUrl: String,
    ) : Abstract(point) {

        private val size = SizeInvertiblePair(50f, 55f)

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

            val progressDrawable = CircularProgressDrawable(view.context).apply {
                strokeWidth = 5f
                centerRadius = 30f
                start()
            }

            (view as? ShapeableImageView)?.also { imageView ->
                imageView.load(imageUrl) {
                    crossfade(true)
                    placeholder(progressDrawable)
                }

                val style = if(isSelected) {
                    R.style.roundRectangleImageView
                } else {
                    R.style.roundCircleImageView
                }

                imageView.shapeAppearanceModel = ShapeAppearanceModel.builder(imageView.context, style, style).build()

                imageView.setOnClickListener {
                    onSelected()
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