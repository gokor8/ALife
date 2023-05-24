package com.alife.domain.core.exception_global

abstract class GlobalException : Throwable()

interface GoToLoginException

class RefreshTokenDied : GlobalException(), GoToLoginException

class LogOut : GlobalException(), GoToLoginException

class ServerUnavailable : GlobalException()

class RetrofitException : GlobalException()