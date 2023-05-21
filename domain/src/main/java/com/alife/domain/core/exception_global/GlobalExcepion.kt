package com.alife.domain.core.exception_global

abstract class GlobalException : Throwable()

class RefreshTokenDied : GlobalException()

class LogOut : GlobalException()

class ServerUnavailable : GlobalException()