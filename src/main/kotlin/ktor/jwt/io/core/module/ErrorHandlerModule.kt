package ktor.jwt.io.core.module

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import ktor.jwt.io.core.base.ApiException
import ktor.jwt.io.core.base.ErrorCode

fun Application.configurationGlobalExceptionHandlerModule() {

    install(StatusPages) {
        exception<ApiException>  { call, cause ->

            call.respond(HttpStatusCode.BadRequest, cause.errorCode.response())
        }
    }
}