package com.bopera.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "rooms")
data class RoomEntity(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "room_name", nullable = false)
    val roomName: String? = null,

    @Column(name = "sort", nullable = false)
    val sort: Int? = 0,

    @OneToMany(mappedBy = "room")
    private val tables: Set<RoomTableEntity> = HashSet(),
)
