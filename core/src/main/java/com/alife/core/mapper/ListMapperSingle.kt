package com.alife.core.mapper

interface ListMapperSingle<M> : Mapper<@JvmSuppressWildcards List<M>, @JvmSuppressWildcards List<M>>

interface ListMapper<M, MR> : Mapper<@JvmSuppressWildcards List<M>, @JvmSuppressWildcards List<MR>>