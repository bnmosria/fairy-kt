package com.bopera.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "inventory")
data class InventoryEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null,

    @Column(name = "stock_quantity", nullable = false)
    private var stockQuantity: Int? = null,

    @Column(name = "reorder_threshold", nullable = false)
    private var reorderThreshold: Int? = null,
)
