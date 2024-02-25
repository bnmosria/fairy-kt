package com.bopera.api.menuitem.controller

import com.bopera.api.menuitem.model.MenuItemRequest
import com.bopera.api.menuitem.model.MenuItemResponse
import com.bopera.domain.menuitem.interfaces.MenuItemService
import com.bopera.domain.menuitem.model.MenuItem
import jakarta.annotation.security.RolesAllowed
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class MenuItemsController(private val menuItemService: MenuItemService) {

    @PostMapping("/menu-items")
    @PreAuthorize("hasRole('USER')")
    fun createMenuItem(@RequestBody menuItemRequest: MenuItemRequest): ResponseEntity<MenuItemResponse> {
        val menuItem = MenuItem(
            name = menuItemRequest.name,
            description = menuItemRequest.description,
            price = menuItemRequest.price
        )

        val savedMenuItem = menuItemService.create(menuItem)

        val menuItemResponse = savedMenuItem.id?.let{
            MenuItemResponse(
                id = it,
                name = savedMenuItem.name,
                description = savedMenuItem.description,
                price = savedMenuItem.price
            )
        }

        return ResponseEntity(menuItemResponse, HttpStatus.CREATED)
    }
}
