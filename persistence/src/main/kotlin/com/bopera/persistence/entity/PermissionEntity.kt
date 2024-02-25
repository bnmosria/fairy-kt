package com.bopera.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "permissions")
data class PermissionEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null,

    @Column(name = "permission_name", nullable = false)
    private var permissionName: String? = null,
)
