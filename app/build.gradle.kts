import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    kotlin("jvm")
}
dependencies {
    implementation(project(":persistence"))

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")
}
