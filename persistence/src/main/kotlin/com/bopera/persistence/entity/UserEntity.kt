package com.bopera.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "username", nullable = false)
    val username: String? = null,

    @Column(name = "active", nullable = false)
    val active: Int? = null,

    @Column(name = "password", nullable = false)
    val password: String? = null,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = [JoinColumn(name = "user_id")], inverseJoinColumns = [JoinColumn(name = "role_id")])
    private val roles: MutableSet<RoleEntity> = HashSet(),
)
