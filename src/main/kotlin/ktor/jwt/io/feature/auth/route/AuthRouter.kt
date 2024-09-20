package ktor.jwt.io.feature.auth.route

import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.AuthRouter() {

    route("/test") {

        get {

            call.respond(mapOf("hello" to "world"))
        }
    }

    route("/auth") {

    }
}