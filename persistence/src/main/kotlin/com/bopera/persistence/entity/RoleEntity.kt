package com.bopera.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class RoleEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "role_name", nullable = false)
    val roleName: String? = null,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_permissions", joinColumns = [JoinColumn(name = "role_id")], inverseJoinColumns = [JoinColumn(name = "permission_id")])
    val permissions: MutableSet<PermissionEntity> = HashSet(),
)
