package com.teddy.board.domain.repository

import com.teddy.board.domain.entity.Board
import com.teddy.board.model.BoardResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
// JpaRepository에서 기본적인 sql crud function제공
interface BoardRepository : JpaRepository<Board, String> {

    override fun findAll(): MutableList<Board>

    fun findAllByUserId(userId : String): MutableList<BoardResponse>

}