package com.feleck.postapi.infra.common.entity

import io.lettuce.core.BitFieldArgs.Offset
import jakarta.annotation.Nullable
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    var id: Long? = null

    @CreatedDate
    @Column(nullable = false)
    var createdAt: OffsetDateTime = OffsetDateTime.now()

    @LastModifiedDate
    @Column
    var updatedAt: OffsetDateTime? = null
}