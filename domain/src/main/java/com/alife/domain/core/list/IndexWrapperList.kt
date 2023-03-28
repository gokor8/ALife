package com.alife.domain.core.list

open class IndexWrapperList<WRAPPER : IndexWrapperModel<M>, M>(
    mapper: ToIndexWrapperMapper<WRAPPER, M>,
    vararg model: M
) : ArrayList<WRAPPER>(model.mapIndexed { index, model -> mapper.map(index, model) })