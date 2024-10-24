package ktor.jwt.io.core.module

import io.ktor.server.application.*
import ktor.jwt.io.feature.auth.application.JwtService
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.SLF4JLogger

val dependencyInjectionModule = module {
    single { JwtService() }
}


fun Application.configurationDependencyInjection() {
    install(Koin){
        SLF4JLogger()
        modules(dependencyInjectionModule)
    }
}