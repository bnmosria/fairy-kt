package com.bopera.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class CategoryEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false, unique = true)
    val name: String? = null,

    @Column(name = "description")
    val description: String? = null,

    @OneToMany(mappedBy = "category")
    val menuItems: Set<MenuItemEntity> = HashSet(),
)
