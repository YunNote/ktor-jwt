package ktor.jwt.io.feature.auth.route

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.jwt.io.feature.auth.application.JwtService
import java.util.*

fun Route.AuthRouter(jwtService: JwtService) {

    route("/test") {

        get {

            jwtService.test()
            call.respond(mapOf("hello" to "world"))
        }
    }
}