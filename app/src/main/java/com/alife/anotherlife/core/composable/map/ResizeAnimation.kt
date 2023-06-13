package com.alife.anotherlife.core.composable.map

import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation


class ResizeAnimation(
    private var view: View,
    private val targetSize: Float,
    private var startSize: Float,
    duration: Long = 1000L
) : Animation() {

    init {
        setDuration(duration)
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        val newSize = (targetSize + startSize * interpolatedTime).toInt()

        view.layoutParams.apply {
            height = newSize
            width = newSize
        }
        view.requestLayout()
    }

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
    }

    override fun willChangeBounds(): Boolean {
        return true
    }
}