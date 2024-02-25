package com.bopera.persistence.entity

import com.bopera.persistence.enums.OrderStatus
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    private val user: UserEntity? = null,

    @ManyToOne
    @JoinColumn(name = "table_id")
    private val tableId: RoomTableEntity? = null,

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    val status: OrderStatus? = null,

    @Column(name = "total_amount")
    val totalAmount: BigDecimal = BigDecimal.valueOf(0.0),

    @Column(name = "timestamp")
    val timestamp: Date? = null,

    @OneToMany(mappedBy = "order")
    val orderItemEntities: List<OrderItemEntity> = ArrayList(),
)
