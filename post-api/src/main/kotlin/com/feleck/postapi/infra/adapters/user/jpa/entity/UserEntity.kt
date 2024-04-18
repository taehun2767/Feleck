package com.feleck.postapi.infra.adapters.user.jpa.entity

import com.feleck.postapi.infra.common.entity.AbstractEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.OffsetDateTime

@Entity
@Table(name = "users")
class UserEntity(
    @Column
    var name: String,
    @Column
    var email: String,
    @Column
    var carName: String
): AbstractEntity()