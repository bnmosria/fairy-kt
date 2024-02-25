package com.bopera.persistence.repository

import com.bopera.persistence.entity.RoleEntity
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RoleRepository : BaseRepository<RoleEntity?, Long?> {
    fun findByRoleName(roleAdmin: String?): Optional<RoleEntity?>?
}
