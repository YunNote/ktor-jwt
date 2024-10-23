package ktor.jwt.io.core.module.util

import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*

object PropertyUtils {

    fun getProperty(key: String): String {
        return HoconApplicationConfig(ConfigFactory.load())
            .property(key)
            .getString()
    }
}