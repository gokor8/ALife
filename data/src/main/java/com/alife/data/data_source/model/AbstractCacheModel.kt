package com.alife.data.data_source.model

abstract class AbstractCacheModel<M>(private val key: String) : CacheModel<M> {

    override fun getKey(): String = key


    abstract class Read<M>(key: String) : AbstractCacheModel<M>(key), CacheModel.Read<M> {

        abstract fun defaultValue(): M
    }

    abstract class Write<M>(
        key: String,
        protected val saveValue: M
    ) : AbstractCacheModel<M>(key), CacheModel.Write<M>
}