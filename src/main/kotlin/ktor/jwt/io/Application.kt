package ktor.jwt.io

import io.ktor.server.application.*
import ktor.jwt.io.core.module.configurationContentNegotiation
import ktor.jwt.io.core.module.configurationDataSourceModule
import ktor.jwt.io.plugins.configureRouting

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configurationDataSourceModule()
    configurationContentNegotiation()
    configureRouting()

}
