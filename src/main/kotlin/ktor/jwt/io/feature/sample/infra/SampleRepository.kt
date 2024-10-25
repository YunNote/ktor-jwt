package ktor.jwt.io.feature.sample.infra

import ktor.jwt.io.core.feature.sample.Sample

interface SampleRepository {

    suspend fun save(name:String, age: Int): Sample
}