package ktor.jwt.io.feature.sample.application

import ktor.jwt.io.core.feature.sample.Sample
import ktor.jwt.io.feature.sample.domain.SampleDataprovider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SampleService{

    suspend fun save(name: String, age: Int) {

        println(123123)
//        return sampleDataprovider.save(name, age);
    }

    fun test() {

        println("HELLO")
    }
}