package com.bopera.persistence.repository

import com.bopera.persistence.entity.PermissionEntity
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PermissionRepository : BaseRepository<PermissionEntity?, Long?> {
    fun findByPermissionName(adminAccess: String?): Optional<PermissionEntity?>?
}
