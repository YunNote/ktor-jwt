package ktor.jwt.io.feature.auth.route

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.jwt.io.feature.auth.application.JwtService
import org.koin.ktor.ext.inject
import java.util.*

fun Route.AuthRouter() {

    val JwtService: JwtService by inject<JwtService>();

    route("/test") {

        get {

            call.respond(mapOf("hello" to "world"))
        }

        get("/login") {
            val token = JWT.create()
                .withAudience("awegwaeg")
                .withIssuer("withIssuer yunjin")
                .withClaim("username", "최윤진")
                .withExpiresAt(Date(System.currentTimeMillis() + 60000))
                .sign(Algorithm.HMAC256("Hello"))
            call.respond(mapOf("token" to token))
        }
    }

    route("/auth") {

    }
}