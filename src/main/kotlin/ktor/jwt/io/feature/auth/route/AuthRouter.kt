package ktor.jwt.io.feature.auth.route

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.jwt.io.feature.auth.application.JwtService
import org.koin.ktor.ext.inject

fun Route.AuthRouter() {

    val jwtService: JwtService by inject<JwtService>();

    route("/test") {

        get {

            jwtService.test()
            call.respond(mapOf("hello" to "world"))
        }
    }
}