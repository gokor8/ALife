package com.alife.domain.registration.usecase.base.entity

interface RegCacheInputEntity<M : Any> : CacheInputEntity<M> {

    interface Save<M : Any> : RegCacheInputEntity<M>, SaveCacheInputEntity<M>

    interface Read<M : Any>: RegCacheInputEntity<M>, ReadCacheInputEntity<M>
}