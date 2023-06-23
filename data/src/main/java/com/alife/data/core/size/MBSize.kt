package com.alife.data.core.size

interface BaseStorageMBSize : StorageSize<Long>

class MBSize(val size: Int) : BaseStorageMBSize {

    private val mbMultiplier = 1024 * 1024L

    override fun getSize(): Long = size * mbMultiplier
}