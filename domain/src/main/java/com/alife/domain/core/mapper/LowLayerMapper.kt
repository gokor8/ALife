package com.alife.domain.core.mapper

import com.alife.core.mapper.MapperHandleElse
import com.alife.domain.core.MappingException

interface LowLayerMapper<I, O> : MapperHandleElse<I, O> {

    override fun onElse(inputModel: I): O = throw MappingException()

    //fun onElse(): O = throw MappingException()

    // TODO вынести в другой интерфейс + подумать над названием этого интерфейса
    fun<R> onElse(): R = throw MappingException()

    // TODO https://stackoverflow.com/a/44868822 может так и обстрагировать этот when
}