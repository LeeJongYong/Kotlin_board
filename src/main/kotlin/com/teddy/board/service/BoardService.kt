package com.teddy.board.service

import com.teddy.board.domain.entity.Board
import com.teddy.board.domain.repository.BoardRepository
import com.teddy.board.model.BoardRequest
import com.teddy.board.model.BoardResponse
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class BoardService (
    private val boardRepository: BoardRepository
) {

    fun create (
        // @todo 유저 데이터 - 하드코딩 > token으로 변경해보기.
        request: BoardRequest
    ) : BoardResponse {

        val board = Board (
            summary = request.summary,
            description = request.description,
            userId = request.email,
            userName = request.userName,
        )
        return BoardResponse(boardRepository.save(board))
    }

}