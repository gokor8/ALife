package com.alife.anotherlife.core.ui.permission.strategy

import com.alife.anotherlife.core.ui.permission.PermissionStatus

interface BaseStrategyMapper {

    fun map(isGranted: Boolean, shouldFailShow: Boolean): PermissionStatus


    class Default : BaseStrategyMapper {
        override fun map(isGranted: Boolean, shouldFailShow: Boolean): PermissionStatus {
            return when {
                isGranted -> PermissionStatus.Success()
                shouldFailShow -> PermissionStatus.Fail()
                else -> PermissionStatus.Fatal()
            }
        }
    }

    class Full : BaseStrategyMapper {
        override fun map(isGranted: Boolean, shouldFailShow: Boolean): PermissionStatus {
            return when {
                isGranted -> PermissionStatus.Success()
                shouldFailShow -> PermissionStatus.Fail()
                else -> PermissionStatus.PreFatal()
            }
        }
    }
}