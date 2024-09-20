package ktor.jwt.io.plugins

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.jwt.io.feature.auth.route.AuthRouter

fun Application.configureRouting() {
    routing {
        AuthRouter()
    }
}
