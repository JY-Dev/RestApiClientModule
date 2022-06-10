package com.jydev.rest_api_util.exception

import java.lang.Exception

class ServerErrorException(override val message: String) : Exception()
class ServerFailException(override val message : String) : Exception()
class IdleException(override val message : String) : Exception()