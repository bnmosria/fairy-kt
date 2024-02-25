package com.bopera.persistence.repository

import com.bopera.persistence.entity.MenuItemEntity
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.math.BigDecimal

@DataJpaTest
@DisplayName("Menu Item Repository Test")
internal class MenuItemsRepositoryTest : BaseRepositoryTest() {
    @Autowired
    private val menuItemsRepository: MenuItemsRepository? = null

    @Test
    @DisplayName("Test if Menu Item can be saved")
    fun shouldSaveMenuItem() {
        val newMenuItem = MenuItemEntity(name = "Test Item", price = BigDecimal.valueOf(10.99))
        val saved = menuItemsRepository!!.save(newMenuItem)

        Assertions.assertNotNull(saved.id)
    }

    @Test
    @DisplayName("Test if Menu Item can be retrieved and updated")
    fun testUpdateMenuItem() {
        val newMenuItem = MenuItemEntity(name = "Test Item", price = BigDecimal.valueOf(10.99))
        val savedMenuItem = menuItemsRepository!!.save(newMenuItem)

        val retrievedSavedMenuItem = savedMenuItem.id?.let { menuItemsRepository.findById(it).orElse(null) }
        val updatedMenuItem = retrievedSavedMenuItem?.copy(name = "Updated Item")

        updatedMenuItem?.let { menuItemsRepository.save(it) }
        val retrievedUpdatedMenuItem = updatedMenuItem?.id?.let { menuItemsRepository.findById(it).orElse(null) }

        Assertions.assertNotNull(retrievedUpdatedMenuItem != null)
        Assertions.assertEquals(retrievedSavedMenuItem?.id, retrievedUpdatedMenuItem?.id)
        Assertions.assertEquals("Updated Item", retrievedUpdatedMenuItem?.name)
    }

    @Test
    @DisplayName("Test if findByName returns the correct MenuItemEntity when given a valid name")
    fun testFindByNameWhenNameIsValidThenReturnCorrectMenuItemEntity() {
        val newMenuItem = MenuItemEntity(name = "Test Item", price = BigDecimal.valueOf(10.99))
        menuItemsRepository!!.save(newMenuItem)

        val foundItems = menuItemsRepository.findByName("Test Item")

        Assertions.assertNotNull(foundItems)
        Assertions.assertEquals(1, foundItems?.size)
        Assertions.assertEquals(newMenuItem.name, foundItems?.get(0)?.name)
    }

    @Test
    @DisplayName("Test if findByName returns an empty list when given a name that does not exist in the repository")
    fun testFindByNameWhenNameDoesNotExistThenReturnEmptyList() {
        val foundItems = menuItemsRepository!!.findByName("Non-existent Item")

        Assertions.assertNotNull(foundItems)
        Assertions.assertTrue(foundItems!!.isEmpty())
    }

    @Test
    @DisplayName("Test if findByName handles null values correctly")
    fun testFindByNameWhenNameIsNullThenReturnEmptyList() {
        val foundItems = menuItemsRepository!!.findByName(null)

        Assertions.assertNotNull(foundItems)
        Assertions.assertTrue(foundItems!!.isEmpty())
    }
}
