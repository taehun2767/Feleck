package com.feleck.postapi.infra.adapters.user.jpa.repository

import com.feleck.postapi.infra.adapters.user.jpa.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserEntityJpaRepository: JpaRepository<UserEntity, Long> {

}
