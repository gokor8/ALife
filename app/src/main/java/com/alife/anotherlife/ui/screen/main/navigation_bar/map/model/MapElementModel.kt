package com.alife.anotherlife.ui.screen.main.navigation_bar.map.model

import android.os.Parcelable
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
import kotlinx.parcelize.Parcelize

interface MapElementModel {

    val point: Point


    fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit)

    @Composable
    fun BottomBarContent(onDetail: (String) -> Unit) = Unit


    abstract class Abstract(override val point: Point) : MapElementModel, Parcelable

    @Parcelize
    class Empty(
        override val point: Point = Point.fromLngLat(0.0, 0.0)
    ) : Abstract(point) {
        override fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit) = Unit
    }

    @Parcelize
    class ImageElement(
        private val username: String,
        private val creationDate: String,
        private val preview: String,
        override val point: Point,
    ) : Abstract(point) {

        private val strokeWidth = 5f
        private val centerRadius = 30f

        override fun onBind(view: View, isSelected: Boolean, onSelected: () -> Unit) {
            val progressDrawable = CircularProgressDrawable(view.context).apply {
                strokeWidth = this@ImageElement.strokeWidth
                centerRadius = this@ImageElement.centerRadius
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
        override fun BottomBarContent(onDetail: (String) -> Unit) {
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

                TextButton(onClick = { onDetail(username) }) {
                    IconBase(icon = R.drawable.ic_right_arrow, modifier = Modifier.padding(6.dp))
                }
            }
        }
    }
}