package ktor.jwt.io.core.module

import io.ktor.server.application.*
import ktor.jwt.io.feature.auth.application.JwtService
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

val appModule = module {
    single { JwtService() }
}

fun Application.configurationDependencyInjection() {
    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }
}