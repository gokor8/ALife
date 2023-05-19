package com.alife.data.interceptor

abstract class GlobalException : Throwable()

class RefreshTokenDied : GlobalException()

class LogOut : GlobalException()