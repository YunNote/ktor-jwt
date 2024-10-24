package ktor.jwt.io.core.module

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import ktor.jwt.io.core.feature.sample.Samples
import ktor.jwt.io.core.module.DatabaseUtil.dropAndCreateTables
import ktor.jwt.io.core.module.util.PropertyUtils
import ktor.jwt.io.core.module.util.PropertyUtils.getProperty
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.math.log

val ROOT_PREFIX = "database"
val PREFIX = "$ROOT_PREFIX.datasource";
val URL = "$PREFIX.url";
val DRIVER_CLASS_NAME = "$PREFIX.driver-class-name";
val USER_NAME = "$PREFIX.username";
val PASSWORD = "$PREFIX.password"
val MAX_POOL_SIZE = "$PREFIX.max-pool-size"
val IS_RESET_TABLES = "$ROOT_PREFIX.reset-tables"

fun Application.configurationDataSourceModule() {
    DatabaseUtil.connectDataSource(this)
    if(DatabaseUtil.isResetTable()) dropAndCreateTables()
}

object DatabaseUtil {

    val tables = arrayOf(Samples);
    fun connectDataSource(application: Application) {
        val hikariCp = HikariDataSource(
            HikariConfig().apply {
                jdbcUrl = getProperty(URL)
                driverClassName = getProperty(DRIVER_CLASS_NAME)
                username = getProperty(USER_NAME)
                password = getProperty(PASSWORD)
                maximumPoolSize = getProperty(MAX_POOL_SIZE).toInt() ?: 10
                validate()
            })
        Database.connect(hikariCp)
//        monitor.subscribe(ApplicationStarted) { application ->
//            application.environment.log.info("HikariCp is Running : ${hikariCp.isRunning}")
//        }
    }


    fun dropAndCreateTables() = transaction {
        SchemaUtils.drop(*tables)
        SchemaUtils.create(*tables)

    }
    fun isResetTable(): Boolean = getProperty(IS_RESET_TABLES).toBoolean()

}