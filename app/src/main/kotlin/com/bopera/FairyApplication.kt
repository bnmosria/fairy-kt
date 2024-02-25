package com.bopera

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("com.bopera.persistence.entity")
class FairyApplication

fun main(args: Array<String>) {
    runApplication<FairyApplication>(*args)
}
