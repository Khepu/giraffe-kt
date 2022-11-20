import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

group = "io.arcanesolutions"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val arrowVersion = "1.1.2"

dependencies {
    implementation("io.arrow-kt:arrow-core:$arrowVersion")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}