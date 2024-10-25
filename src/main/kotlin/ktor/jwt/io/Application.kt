package ktor.jwt.io

import io.ktor.server.application.*
import ktor.jwt.io.core.module.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configurationDependencyInjection()
    configurationDataSourceModule()
    configurationContentNegotiation()
    configureRouting()
    configurationGlobalExceptionHandlerModule()

}
