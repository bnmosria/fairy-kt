package com.bopera.domain.menuitem.model

import java.math.BigDecimal

data class MenuItem(
    val id: Long? = null,
    val name: String,
    val description: String,
    val price: BigDecimal,
)
