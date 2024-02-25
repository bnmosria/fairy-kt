package com.bopera.persistence.repository

import com.bopera.persistence.entity.MenuItemEntity
import org.springframework.stereotype.Repository

@Repository
interface MenuItemsRepository : BaseRepository<MenuItemEntity?, Long?> {
    fun findByName(menuItemName: String?): List<MenuItemEntity?>?
}
