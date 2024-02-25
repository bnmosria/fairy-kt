package com.bopera.api.menuitem.model

import java.math.BigDecimal

class MenuItemRequest(
    val name: String,
    val description: String,
    val price: BigDecimal = BigDecimal.valueOf(0.00),
)
