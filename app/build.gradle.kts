plugins {
    kotlin("jvm")
}
dependencies {
    implementation(project(":api"))
    implementation(project(":domain"))
    implementation(project(":persistence"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")
}
