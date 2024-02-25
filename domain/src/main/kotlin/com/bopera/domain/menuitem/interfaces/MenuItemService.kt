package com.bopera.domain.menuitem.interfaces

import com.bopera.domain.menuitem.model.MenuItem

interface MenuItemService {
    fun create(menuItem: MenuItem): MenuItem
}
