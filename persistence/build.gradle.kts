plugins {
    kotlin("jvm")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("mysql:mysql-connector-java:8.0.29")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("com.h2database:h2:2.2.224")
    implementation("org.hibernate.orm:hibernate-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-maven-noarg:1.9.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.hibernate.orm:hibernate-testing")
    testImplementation("com.h2database:h2:2.2.224")
}
