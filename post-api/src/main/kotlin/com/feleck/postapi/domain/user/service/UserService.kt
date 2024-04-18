package com.feleck.postapi.domain.user.service

import com.feleck.postapi.infra.adapters.user.jpa.entity.UserEntity
import com.feleck.postapi.infra.adapters.user.jpa.repository.UserEntityJpaRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

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

    fun updateUser(userId: Long, name: String?, email: String?, carName: String?): UserEntity{
        var user: UserEntity = userEntityJpaRepository.findById(userId).orElseThrow { RuntimeException("User not found") }

        if(name.isNullOrEmpty() == false && user.name != name)
            user.name = name

        if(email.isNullOrEmpty() == false && user.email != email)
            user.email = email

        if(carName.isNullOrEmpty() == false && user.carName != carName)
            user.carName = carName

        return userEntityJpaRepository.save(user)
    }

}
