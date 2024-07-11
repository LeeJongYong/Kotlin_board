package com.teddy.board.controller

import com.teddy.board.model.BoardRequest
import com.teddy.board.service.BoardService
import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

// json데이터를 받으려면 @RestController 사용!
@RestController
@RequestMapping("/api/board")
class BoardController(
    // java의 @Autowire 대신 인자 위치에서 사용
    private val boardService: BoardService
) {

    @PostMapping
    fun create(
        @RequestBody board: BoardRequest
    ) {
        boardService.create(board)
    }

}