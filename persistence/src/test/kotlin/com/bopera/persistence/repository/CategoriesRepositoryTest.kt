package com.bopera.persistence.repository

import com.bopera.persistence.entity.CategoryEntity
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Categories Repository Test")
internal class CategoriesRepositoryTest : BaseRepositoryTest() {
    @Autowired
    private val categoriesRepository: CategoriesRepository? = null

    @Test
    @DisplayName("Test if Category can be saved")
    fun shouldSaveCategory() {
        val newCategory = CategoryEntity(name = "Test Category")
        val saved = categoriesRepository!!.save(newCategory)

        Assertions.assertNotNull(saved.id)
    }

    @Test
    @DisplayName("Test if Category can be retrieved and updated")
    fun testUpdateCategory() {
        val newCategory = CategoryEntity(name = "Test Category")
        val savedCategory = categoriesRepository!!.save(newCategory)

        val retrievedSavedCategory = savedCategory.id?.let { categoriesRepository.findById(it).orElse(null) }
        val updatedCategory = retrievedSavedCategory?.copy(name = "Updated Category")

        updatedCategory?.let { categoriesRepository.save(it) }
        val retrievedUpdatedCategory = updatedCategory?.id?.let { categoriesRepository.findById(it).orElse(null) }

        Assertions.assertNotNull(retrievedUpdatedCategory != null)
        Assertions.assertEquals("Updated Category", retrievedUpdatedCategory?.name)
    }

    @Test
    @DisplayName("Test if findByName returns the correct CategoryEntity when given a valid name")
    fun testFindByNameWhenNameIsValidThenReturnCorrectCategoryEntity() {
        val newCategory = CategoryEntity(name = "Test Category")
        categoriesRepository!!.save(newCategory)

        val foundCategories = categoriesRepository.findByName("Test Category")

        Assertions.assertNotNull(foundCategories)
        Assertions.assertEquals(1, foundCategories?.size)
        Assertions.assertEquals(newCategory.name, foundCategories?.get(0)?.name)
    }

    @Test
    @DisplayName("Test if findByName returns an empty list when given a name that does not exist in the repository")
    fun testFindByNameWhenNameDoesNotExistThenReturnEmptyList() {
        val foundCategories = categoriesRepository!!.findByName("Non-existent Category")

        Assertions.assertNotNull(foundCategories)
        Assertions.assertTrue(foundCategories!!.isEmpty())
    }

    @Test
    @DisplayName("Test if findByName handles null values correctly")
    fun testFindByNameWhenNameIsNullThenReturnEmptyList() {
        val foundCategories = categoriesRepository!!.findByName(null)

        Assertions.assertNotNull(foundCategories)
        Assertions.assertTrue(foundCategories!!.isEmpty())
    }

    @Test
    @DisplayName("Test if multiple categories can be added and retrieved using findAll")
    fun testAddMultipleCategoriesAndFindAll() {
        val category1 = CategoryEntity(name = "Category 1")
        val category2 = CategoryEntity(name = "Category 2")
        val category3 = CategoryEntity(name = "Category 3")

        categoriesRepository!!.saveAll(listOf(category1, category2, category3))

        val allCategories = categoriesRepository.findAll()

        Assertions.assertEquals(3, allCategories.size)
        Assertions.assertTrue(allCategories.contains(category1))
        Assertions.assertTrue(allCategories.contains(category2))
        Assertions.assertTrue(allCategories.contains(category3))
    }

    @Test
    @DisplayName("Test if adding a duplicate category throws an exception")
    fun testAddDuplicateCategory() {
        val category = CategoryEntity(name = "Duplicate Category")
        categoriesRepository!!.save(category)

        val duplicateCategory = CategoryEntity(name = "Duplicate Category")

        Assertions.assertThrows(Exception::class.java) {
            categoriesRepository.save(duplicateCategory)
        }
    }
}
