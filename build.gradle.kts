val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project
val exposed_version: String by project
val mysql_version: String by project

plugins {
    kotlin("jvm") version "2.0.20"
    id("io.ktor.plugin") version "3.0.0-rc-1"
}

group = "ktor.jwt.io"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-client-cio-jvm:3.0.0-rc-1")
    testImplementation("io.ktor:ktor-server-test-host-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // JWT
    implementation("io.ktor:ktor-server-auth:$kotlin_version")
    implementation("io.ktor:ktor-server-auth-jwt:$kotlin_version")

    // ContentNegotiation
    implementation("io.ktor:ktor-serialization-kotlinx-json:$kotlin_version")
    implementation("io.ktor:ktor-server-content-negotiation:$kotlin_version")

    // KOIN
    implementation("io.insert-koin:koin-ktor:$koin_version")
    implementation("io.insert-koin:koin-logger-slf4j:$koin_version")

    // Exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposed_version")

    //HikariCP
    implementation("com.zaxxer:HikariCP:6.0.0")

    implementation("mysql:mysql-connector-java:$mysql_version")


}
