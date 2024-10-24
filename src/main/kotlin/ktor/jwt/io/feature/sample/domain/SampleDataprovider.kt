package ktor.jwt.io.feature.sample.domain

import ktor.jwt.io.core.feature.sample.Sample
import ktor.jwt.io.feature.sample.infra.SampleRepository
import org.jetbrains.exposed.sql.transactions.transaction

class SampleDataprovider(private val sampleRepositoryImpl: SampleRepository) {

    suspend fun save(name: String, age: Int) : Sample{
        return sampleRepositoryImpl.save(name, age)
    }
}