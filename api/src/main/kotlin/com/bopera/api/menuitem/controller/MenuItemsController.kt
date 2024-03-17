package com.bopera.api.menuitem.controller

import com.bopera.api.menuitem.model.MenuItemRequest
import com.bopera.api.menuitem.model.MenuItemResponse
import com.bopera.domain.menuitem.interfaces.MenuItemService
import com.bopera.domain.menuitem.model.MenuItem
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/v1/menu-items")
class MenuItemsController(private val menuItemService: MenuItemService) {

    @PostMapping
    fun createMenuItem(@RequestBody menuItemRequest: MenuItemRequest): ResponseEntity<MenuItemResponse> {
        val menuItem = MenuItem(
                name = menuItemRequest.name,
                description = menuItemRequest.description,
                price = menuItemRequest.price
        )

        val savedMenuItem = menuItemService.create(menuItem)

        val menuItemResponse = savedMenuItem.id?.let {
            MenuItemResponse(
                    id = it,
                    name = savedMenuItem.name,
                    description = savedMenuItem.description,
                    price = savedMenuItem.price
            )
        }

        return ResponseEntity(menuItemResponse, HttpStatus.CREATED)
    }

    @GetMapping
    fun getMenuIteList(): ResponseEntity<List<MenuItemResponse>> {
        val menuItemResponse = MenuItemResponse(
                id = 1234,
                name = "name",
                description = "description",
                price = BigDecimal.valueOf(12345, 2)
        )

        return ResponseEntity.ok(listOf( menuItemResponse))
    }

    @GetMapping("/{id}")
    fun getMenuItem(@PathVariable id: String): ResponseEntity<MenuItemResponse> {
        val menuItemResponse = MenuItemResponse(
            id = 1234,
            name = "name",
            description = "description",
            price = BigDecimal.valueOf(12345, 2)
        )

        return ResponseEntity.ok(menuItemResponse)
    }
}
