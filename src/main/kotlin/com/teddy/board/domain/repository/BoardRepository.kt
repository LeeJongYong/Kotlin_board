package com.teddy.board.domain.repository

import com.teddy.board.domain.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
// JpaRepository에서 기본적인 sql crud function제공
interface BoardRepository : JpaRepository<Board, String> {



}