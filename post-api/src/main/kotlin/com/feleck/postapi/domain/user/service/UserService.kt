package com.feleck.postapi.domain.user.service

import com.feleck.postapi.infra.adapters.user.jpa.entity.UserEntity
import com.feleck.postapi.infra.adapters.user.jpa.repository.UserEntityJpaRepository
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userEntityJpaRepository: UserEntityJpaRepository
){

    fun createUser(user: UserEntity): UserEntity {
        return userEntityJpaRepository.save(user)
    }

    fun deleteUserById(userId: Long) {
        userEntityJpaRepository.deleteById(userId)
    }

}
