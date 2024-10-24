package ktor.jwt.io.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import ktor.jwt.io.feature.auth.application.JwtService
import ktor.jwt.io.feature.auth.route.AuthRouter
import ktor.jwt.io.feature.sample.application.SampleService
import ktor.jwt.io.feature.sample.domain.SampleDataprovider
import ktor.jwt.io.feature.sample.infra.SampleRepository
import ktor.jwt.io.feature.sample.infra.SampleRepositoryImpl
import ktor.jwt.io.feature.sample.route.SampleRouter

fun Application.configureRouting() {
    routing {
        AuthRouter(JwtService())
        SampleRouter(SampleService(SampleDataprovider(SampleRepositoryImpl())))
    }
}
