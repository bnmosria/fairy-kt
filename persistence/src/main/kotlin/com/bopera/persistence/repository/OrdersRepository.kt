package com.bopera.persistence.repository

import com.bopera.persistence.entity.OrderEntity
import org.springframework.stereotype.Repository

@Repository
interface OrdersRepository : BaseRepository<OrderEntity?, Long?>
