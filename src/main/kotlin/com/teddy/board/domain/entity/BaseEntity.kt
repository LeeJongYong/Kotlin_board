package com.teddy.board.domain.entity

import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

// @MappedSuperclass : 공통 필드가 있을 경우 부모 클래스에서 선언 후 자식 클래스에서 상속
@MappedSuperclass
// @EntityListeners : JPA Entity에서 이벤트 발생 시 실행하기 위한 annotation
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity (

    @CreatedDate
    var createdDt: LocalDateTime?= null,

    @LastModifiedDate
    var updatedDt: LocalDateTime?= null,
)

