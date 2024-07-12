package com.teddy.board.service

import com.teddy.board.domain.entity.Board
import com.teddy.board.domain.repository.BoardRepository
import com.teddy.board.model.BoardRequest
import com.teddy.board.model.BoardResponse
import jakarta.transaction.Transactional
import mu.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class BoardService (
    private val boardRepository: BoardRepository
) {

    @Transactional
    // 글 작성
    fun create (
        // @todo 유저 데이터 - 하드코딩 > token으로 변경해보기.
        request: BoardRequest
    ): BoardResponse {

        val board = Board (
            summary = request.summary,
            description = request.description,
            userId = request.email,
            userName = request.userName,
        )
        return BoardResponse(boardRepository.save(board))
    }

    @Transactional
    // 글 전체 조회
    fun getAll() = boardRepository.findAll().map { BoardResponse(it) }

    @Transactional
    // 작성 유저의 모든 글 조회
    fun getDocs(userId: String): MutableList<BoardResponse> = boardRepository.findAllByUserId(userId)

    @Transactional
    fun updateDocsById(id: Long, request: BoardRequest): BoardResponse {
        val board: Board = boardRepository.findByIdOrNull(id.toString())!!

        return with(board){
            summary = request.summary
            description = request.description
            this.id = id
            userId = request.email
            userName = request.userName
            BoardResponse(boardRepository.save(this))
        }
    }

    fun deleteDocsById(id: Long): Int {
        boardRepository.deleteById(id.toString())
        return boardRepository.findAll().size
    }
}
