import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    base
    id("org.jetbrains.kotlin.jvm") version "1.9.22" apply false
    id("org.jetbrains.kotlin.plugin.spring") version "1.9.21" apply false
    id("org.springframework.boot") version "3.2.2" apply false
}

allprojects {
    group = "com.bopera"
    version = "1.0-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    println("Enabling Kotlin Spring plugin in project ${project.name}...")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    println("Enabling Spring Boot Dependency Management in project ${project.name}...")
    apply(plugin = "io.spring.dependency-management")

    the<DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    tasks.withType<KotlinCompile>().configureEach {
        println("Configuring $name in project ${project.name}...")
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_21.toString()
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        jvmArgs("-XX:+EnableDynamicAgentLoading")
    }
}
