package com.alife.core.addons

interface AsModel {

    fun<M> asModel(inputModel: Any) = inputModel as? M
}