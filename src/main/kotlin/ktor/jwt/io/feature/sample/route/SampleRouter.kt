package ktor.jwt.io.feature.sample.route

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ktor.jwt.io.feature.auth.application.dto.PersistSample
import ktor.jwt.io.feature.sample.application.SampleService
import org.koin.ktor.ext.inject

fun Route.SampleRouter() {

    val sampleService: SampleService by inject<SampleService>();

    route("/sample"){
        get {
            sampleService.test()
            call.respond(mapOf("Sample" to "Service"))
        }

        get("/save") {
            val save = sampleService.save("최윤진", 22)

            val response = PersistSample.Response(save.name, save.age)
            call.respond(response)
        }
    }
}