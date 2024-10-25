package ktor.jwt.io.feature.auth.application.dto

import kotlinx.serialization.Serializable

class PersistSample {


    @Serializable
    data class Response(val name: String, val age: Int)
}