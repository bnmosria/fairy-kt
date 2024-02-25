package com.bopera.persistence.repository

import com.bopera.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : BaseRepository<UserEntity?, Long?> {
    @Query(value = "SELECT * FROM users WHERE active = 1", nativeQuery = true)
    fun findLoginUserList(): Optional<List<UserEntity?>?>?

    fun findByUsername(@Param("username") username: String?): Optional<UserEntity?>?

    fun existsByUsername(admin: String?): Boolean
}
