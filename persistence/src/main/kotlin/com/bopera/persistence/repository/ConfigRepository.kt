package com.bopera.persistence.repository

import com.bopera.persistence.entity.ConfigurationEntity
import org.springframework.stereotype.Repository

@Repository
interface ConfigRepository : BaseRepository<ConfigurationEntity?, Long?>
