package com.bopera.api.menuitem.model

import java.math.BigDecimal

data class MenuItemResponse(val id: Long, val name: String, val description: String, val price: BigDecimal)
