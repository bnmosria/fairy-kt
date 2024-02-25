package com.bopera.persistence.repository

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@ActiveProfiles("test")
@EntityScan("com.bopera.persistence.entity")
abstract class BaseRepositoryTest
