package ktor.jwt.io.feature.sample.infra

import ktor.jwt.io.core.feature.sample.Sample

class SampleRepositoryImpl : SampleRepository {

    override suspend fun save(name: String, age: Int): Sample {
        return Sample.new {
            this.name = name
            this.age = age
        }
    }
}