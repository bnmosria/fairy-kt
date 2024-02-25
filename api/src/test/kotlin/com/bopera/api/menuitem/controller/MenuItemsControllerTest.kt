package com.bopera.api.menuitem.controller

import com.bopera.api.menuitem.model.MenuItemRequest
import com.bopera.domain.menuitem.interfaces.MenuItemService
import com.bopera.domain.menuitem.model.MenuItem
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.math.BigDecimal

@WebMvcTest(MenuItemsController::class)
class MenuItemsControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var menuItemService: MenuItemService

    private val objectMapper = ObjectMapper()

    private val menuItem = MenuItem(
            id = 1L,
            name = "Test Item",
            description = "Test Description",
            price = BigDecimal.valueOf(10.00)
    )

    @Test
    @WithMockUser
    fun `should returns a menu item response object`() {
        val menuItemRequest = MenuItemRequest(
            name = "Test Item",
            description = "Test Description",
            price = BigDecimal.valueOf(10.00)
        )

        every { menuItemService.create(any()) } returns menuItem

        mockMvc.post("/api/v1/menu-items") {
            with(csrf())
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(menuItemRequest)
        }.andExpect {
            status { isCreated() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json(objectMapper.writeValueAsString(menuItem)) }
        }
    }
}
