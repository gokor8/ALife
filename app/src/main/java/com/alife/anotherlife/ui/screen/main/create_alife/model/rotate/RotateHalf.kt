package com.alife.anotherlife.ui.screen.main.create_alife.model.rotate

class RotateHalf : Rotate {

    override fun rotation(): Float = 180f

    override fun nextRotate(): Rotate = RotateZero()
}