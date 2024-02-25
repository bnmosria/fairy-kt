package com.bopera.persistence.repository

import com.bopera.persistence.entity.RoomTableEntity
import org.springframework.stereotype.Repository

@Repository
interface TableRepository : BaseRepository<RoomTableEntity?, Long?>
