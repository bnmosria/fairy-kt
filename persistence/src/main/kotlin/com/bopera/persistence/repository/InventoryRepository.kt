package com.bopera.persistence.repository

import com.bopera.persistence.entity.InventoryEntity
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository : BaseRepository<InventoryEntity?, Long?>
