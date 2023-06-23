package com.alife.domain.core.list

interface ToIndexWrapperMapper<WRAPPER : IndexWrapperModel<M>, M> {

    fun map(index: Int, model: M): WRAPPER
}