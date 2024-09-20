package ktor.jwt.io

import io.ktor.server.application.*
import ktor.jwt.io.plugins.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureRouting()
}
