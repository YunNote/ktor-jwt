package ktor.jwt.io.feature.sample.application

import ktor.jwt.io.core.feature.sample.Sample
import ktor.jwt.io.feature.sample.domain.SampleDataprovider
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class SampleService(private val sampleDataprovider: SampleDataprovider){

    suspend fun save(name: String, age: Int) : Sample{

        println(123123)
        return newSuspendedTransaction {
            sampleDataprovider.save(name, age);
        }
    }

    fun test() {

        println("HELLO")
    }
}