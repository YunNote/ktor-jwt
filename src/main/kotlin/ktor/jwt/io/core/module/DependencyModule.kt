package ktor.jwt.io.core.module

import io.ktor.server.application.*
import ktor.jwt.io.feature.auth.application.JwtService
import ktor.jwt.io.feature.sample.application.SampleService
import ktor.jwt.io.feature.sample.domain.SampleDataprovider
import ktor.jwt.io.feature.sample.infra.SampleRepository
import ktor.jwt.io.feature.sample.infra.SampleRepositoryImpl
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.SLF4JLogger

val dependencyInjectionModule = module {
    single { JwtService() }
}

val sampleDependencyModule = module {

    single<SampleRepository>{ SampleRepositoryImpl() }
    single { SampleDataprovider(get()) }
    single {SampleService(get())}
}


fun Application.configurationDependencyInjection() {
    install(Koin){
        SLF4JLogger()
        modules(listOf(dependencyInjectionModule, sampleDependencyModule))
    }
}