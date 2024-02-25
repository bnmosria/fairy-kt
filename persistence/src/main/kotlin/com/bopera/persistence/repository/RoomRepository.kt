package com.bopera.persistence.repository

import com.bopera.persistence.entity.RoomEntity
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : BaseRepository<RoomEntity?, Long?>
