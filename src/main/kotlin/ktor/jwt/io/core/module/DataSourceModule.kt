package ktor.jwt.io.core.module

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database
import kotlin.math.log

val PREFIX = "database.datasource";
val URL = "${PREFIX}.url";
val DRIVER_CLASS_NAME = "${PREFIX}.driver-class-name";
val USER_NAME = "${PREFIX}.username";
val PASSWORD = "${PREFIX}.password"
val MAX_POOL_SIZE = "${PREFIX}.max-pool-size"

fun Application.configurationDataSourceModule() {
    connectDatabase(this)

}

fun connectDatabase(application: Application) {
    val hikariCp = HikariDataSource(
        HikariConfig().apply {
            jdbcUrl = getDataSourceConfig(URL)
            driverClassName = getDataSourceConfig(DRIVER_CLASS_NAME)
            username = getDataSourceConfig(USER_NAME)
            password = getDataSourceConfig(PASSWORD)
            maximumPoolSize = getDataSourceConfig(MAX_POOL_SIZE).toInt()
            validate()
        }
    )

    Database.connect(hikariCp)
    application.monitor.subscribe(ApplicationStarted) { application ->
        application.environment.log.info("HikariCp is Running : ${hikariCp.isRunning}")
    }
}

fun getDataSourceConfig(key : String) : String {
    return HoconApplicationConfig(ConfigFactory.load())
        .property(key)
        .getString()
}