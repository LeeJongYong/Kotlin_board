package com.teddy.board.controller

import com.teddy.board.model.BoardRequest
import com.teddy.board.model.BoardResponse
import com.teddy.board.service.BoardService
import mu.KotlinLogging
import org.hibernate.annotations.Parameter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

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
    ) = boardService.create(board)


    @GetMapping
    fun getAllDocs() = boardService.getAll()

    @GetMapping("/{userId}")
    fun getDocsById(
        @PathVariable("userId") userId: String
    ) = boardService.getDocs(userId)

    @PutMapping("/{id}")
    fun updateDocsById(
        @PathVariable("id") id: Long,
        @RequestBody request: BoardRequest,
    ) = boardService.updateDocsById(id, request)

    @DeleteMapping("/{id}")
    fun deleteDocsById(
        @PathVariable("id") id: Long,
    ) = boardService.deleteDocsById(id)
}