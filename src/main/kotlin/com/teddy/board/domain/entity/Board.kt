package com.teddy.board.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "board")
class Board (
    // primary key 필드의 경우 @Id를 사용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var summary: String,

    @Column
    var description: String,

    @Column
    var userId: String,

    @Column
    var userName: String,

) : BaseEntity()        // 공통 필드인 createdDt, updatedDt 를 사용하기 위해 상속