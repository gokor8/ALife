package com.alife.anotherlife.ui.screen.main.create_alife.model.rotate

class RotateZero : Rotate {

    override fun rotation(): Float = 0f

    override fun nextRotate(): Rotate {
        return RotateHalf()
    }
}