package com.bopera.persistence.repository

import com.bopera.persistence.entity.OrderItemEntity
import org.springframework.stereotype.Repository

@Repository
interface OrderItemsRepository : BaseRepository<OrderItemEntity?, Long?>
