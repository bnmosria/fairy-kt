plugins {
    kotlin("jvm")
}
dependencies {
    implementation(project(":persistence"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
