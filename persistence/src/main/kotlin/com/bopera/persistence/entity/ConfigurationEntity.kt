package com.bopera.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "config")
data class ConfigurationEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null,

    @Column(name = "setting")
    val setting: String? = null,
)
