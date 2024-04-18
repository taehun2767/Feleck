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
    //TODO delete

    //TODO retrieve


}