package ktor.jwt.io.core.base

class ApiException(val errorCode: ErrorCode) : RuntimeException(errorCode.message){

}