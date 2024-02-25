package com.bopera.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "room_tables")
data class RoomTableEntity(
        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(name = "table_name", nullable = false)
        val name: String? = null,

        @Column(name = "table_number")
        val tableNumber: String? = null,

        @Column(name = "active")
        val active: Int = 0,

        @Column(name = "sort")
        val sort: Int = 0,

        @ManyToOne
        @JoinColumn(name = "room_id", nullable = false)
        val room: RoomEntity? = null,
)
