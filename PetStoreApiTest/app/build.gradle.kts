import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    kotlin("plugin.serialization") version "1.4.31"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

group = "io.github.partyzaner"
version = "1.0"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used by the application.
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("io.rest-assured:kotlin-extensions:5.1.1")


    compileOnly("org.springframework.boot:spring-boot-dependencies:2.7.1")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        exceptionFormat = TestExceptionFormat.SHORT
        showCauses = true
        showExceptions = true
        showStackTraces = true
    }
}

//application {
//    // Define the main class for the application.
//    mainClass.set("PetStoreApiTest.AppKt")
//}
