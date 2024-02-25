package com.bopera.persistence.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "menu_items")
data class MenuItemEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null,

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "price", nullable = false)
    val price: BigDecimal? = null,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: CategoryEntity? = null,

    @OneToMany(mappedBy = "menuItem")
    val orderItemEntities: Set<OrderItemEntity> = HashSet()
)
