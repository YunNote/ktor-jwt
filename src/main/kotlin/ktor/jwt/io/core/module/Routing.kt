package ktor.jwt.io.core.module

import io.ktor.server.application.*
import io.ktor.server.routing.*
import ktor.jwt.io.feature.auth.route.AuthRouter
import ktor.jwt.io.feature.sample.route.SampleRouter

fun Application.configureRouting() {
    routing {
        AuthRouter()
        SampleRouter()
    }
}
