package com.alife.core.mapper

interface Mapper<I, O> {

    fun map(inputModel: I): O
}