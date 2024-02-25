package com.bopera.persistence.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "order_items")
data class OrderItemEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "quantity", nullable = false)
    val quantity: Int? = null,

    @Column(name = "subtotal", nullable = false)
    val subtotal: BigDecimal? = null,

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private val menuItem: MenuItemEntity? = null,

    @ManyToOne
    @JoinColumn(name = "order_id")
    private val order: OrderEntity? = null,
)
