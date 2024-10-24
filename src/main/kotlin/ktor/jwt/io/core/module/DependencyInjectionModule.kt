package ktor.jwt.io.core.module

import io.ktor.server.application.*
import ktor.jwt.io.feature.auth.application.JwtService
import ktor.jwt.io.feature.sample.application.SampleService
import ktor.jwt.io.feature.sample.domain.SampleDataprovider
import ktor.jwt.io.feature.sample.infra.SampleRepository
import ktor.jwt.io.feature.sample.infra.SampleRepositoryImpl
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

val appModule = module {
    single { JwtService() }
    single { SampleService() }
}

val sampleModule = module {
//    single<SampleRepository> { SampleRepositoryImpl()}
//    single { SampleDataprovider(get()) }

}

fun Application.configurationDependencyInjection() {
//    startKoin{
//        modules(listOf(appModule, sampleModule))
//    }
    install(Koin) {
        slf4jLogger()
        modules(listOf(appModule, sampleModule))
    }
}