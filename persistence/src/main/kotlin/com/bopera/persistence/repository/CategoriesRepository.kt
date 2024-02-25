package com.bopera.persistence.repository

import com.bopera.persistence.entity.CategoryEntity
import org.springframework.stereotype.Repository

@Repository
interface CategoriesRepository : BaseRepository<CategoryEntity?, Long?> {
    fun findByName(categoryName: String?): List<CategoryEntity?>?
}
