package com.alife.core.mapper

interface MapperHandleElse<I, O> : Mapper<I, O> {

    fun onElse(inputModel: I): O
}