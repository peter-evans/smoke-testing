import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
    java
    application
}

group = "com.github.peter-evans"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val kotlinVersion = "1.3.21"
    compile(kotlin("stdlib-jdk8", kotlinVersion))

    val junitVersion = "5.3.2"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testCompile(kotlin("test-junit5", kotlinVersion))

    val dropwizardVersion = "1.3.9"
    compile("io.dropwizard:dropwizard-core:$dropwizardVersion")
}

application {
    mainClassName = "com.github.peterevans.exampleapi.ExampleApiApplication"
}

tasks {
    "test"(Test::class) {
        useJUnitPlatform()
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.named<JavaExec>("run") {
    args("server", "./config/local.yml")
}
