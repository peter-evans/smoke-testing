import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
    java
    application
}

group = "com.github.peter-evans"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val kotlinVersion = "1.3.+"
    implementation(kotlin("stdlib-jdk8", kotlinVersion))

    val junitVersion = "5.3.+"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation(kotlin("test-junit5", kotlinVersion))

    val dropwizardVersion = "1.3.+"
    implementation("io.dropwizard:dropwizard-core:$dropwizardVersion")
}

dependencyLocking {
    lockAllConfigurations()
}

application {
    mainClassName = "com.github.peterevans.exampleapi.ExampleApiApplication"
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    "test"(Test::class) {
        useJUnitPlatform()
    }

    named<JavaExec>("run") {
        args("server", "./config/local.yml")
    }
}
