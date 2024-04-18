package com.feleck.postapi.domain.user.service

import com.feleck.postapi.infra.adapters.user.jpa.entity.UserEntity
import com.feleck.postapi.infra.adapters.user.jpa.repository.UserEntityJpaRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.assertj.core.api.Assertions.assertThat
import org.mockito.Mockito.*
import java.time.OffsetDateTime
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @Mock
    private lateinit var userEntityJpaRepository: UserEntityJpaRepository

    @InjectMocks
    private lateinit var userService: UserService

    //TODO create
    @Test
    fun shouldCreateUserSuccessfully(){
        // given
        val user = UserEntity(
            name = "태훈",
            email = "abc2767@snu.ac.kr",
            carName = "아반떼",
        )

        // when
        `when`(userEntityJpaRepository.save(user)).thenReturn(user)
        val savedUser = userService.createUser(user)

        // then
        assertThat(savedUser).isEqualTo(user)
        verify(userEntityJpaRepository).save(user)
    }


    //TODO remove
    @Test
    fun shouldDeleteUserSuccessfully(){
        //given
        val userId = 1L;

        //when
        userService.deleteUserById(userId)

        //then
        verify(userEntityJpaRepository, times(1)).deleteById(userId)
    }

    //TODO update

    @Test
    fun shouldUpdateSuccessfully(){
        //given
        val userId = 1L
        val user = UserEntity(
            name = "태훈",
            email = "abc2767@snu.ac.kr",
            carName = "아반떼",
        )

        var updatedName = "바뀐 이름"
        var updatedEmail = "바뀐 이메일"
        var updatedCarName = "바뀐 카"

        //when
        `when`(userEntityJpaRepository.save(user)).thenReturn(user)
        `when`(userEntityJpaRepository.findById(userId)).thenReturn(Optional.of(user))
        user.name = updatedName
        user.email = updatedEmail
        user.carName = updatedCarName

        val updatedUser = userService.updateUser(userId, updatedName, updatedEmail, updatedCarName)

        //then
        assertThat(updatedUser).isEqualTo(user)
        verify(userEntityJpaRepository, times(1)).save(user)
        verify(userEntityJpaRepository, times(1)).findById(userId)
    }

    //TODO delete

    //TODO retrieve


}