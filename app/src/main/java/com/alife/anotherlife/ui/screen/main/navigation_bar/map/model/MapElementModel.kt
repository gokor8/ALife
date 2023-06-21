package com.alife.anotherlife.ui.screen.main.navigation_bar.map.model

import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.image.ExtendImageBase
import com.alife.anotherlife.core.composable.text.style.style10W400
import com.alife.anotherlife.core.composable.text.style.style14W400
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.mapbox.geojson.Point

interface MapElementModel {

    val point: Point


    fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit)

    @Composable
    fun BottomBarContent(onDetail: () -> Unit) = Unit


    abstract class Abstract(override val point: Point) : MapElementModel

    class Empty(
        point: Point = Point.fromLngLat(0.0, 0.0)
    ) : Abstract(point) {
        override fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit) = Unit
    }

    class ImageElement(
        private val username: String,
        private val creationDate: String,
        private val preview: String,
        point: Point,
    ) : Abstract(point) {

        private val size = SizeInvertiblePair(50f, 55f)

        override fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit) {
            val sizes = size.getPair(isSelected)

            val progressDrawable = CircularProgressDrawable(view.context).apply {
                strokeWidth = 5f
                centerRadius = 30f
                start()
            }

            (view as? ShapeableImageView)?.also { imageView ->
                imageView.load(preview) {
                    crossfade(true)
                    placeholder(progressDrawable)
                }

                val style = if (isSelected) {
                    R.style.roundRectangleImageView
                } else {
                    R.style.roundCircleImageView
                }

                imageView.shapeAppearanceModel =
                    ShapeAppearanceModel.builder(imageView.context, style, style).build()

                imageView.setOnClickListener { onSelected() }
            }
        }

        @Composable
        override fun BottomBarContent(onDetail: () -> Unit) {
            Row(modifier = Modifier.fillMaxWidth()) {
                ExtendImageBase(
                    model = preview,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 14.dp)
                        .size(105.dp)
                )

                Column(modifier = Modifier.padding(vertical = 26.dp)) {
                    Text(username, style = style14W400())
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(creationDate, style = style14W400(Color.Unspecified.copy(alpha = .6f)))

                    Text(text = "${point.longitude()}, ${point.latitude()}", style = style10W400())
                }
                Spacer(modifier = Modifier.weight(1f))

                TextButton(onClick = onDetail) {
                    IconBase(icon = R.drawable.ic_right_arrow, modifier = Modifier.padding(6.dp))
                }
            }
        }
    }
}