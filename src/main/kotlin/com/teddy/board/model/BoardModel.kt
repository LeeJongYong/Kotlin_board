package com.teddy.board.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.teddy.board.domain.entity.Board
import java.time.LocalDateTime

data class BoardRequest(
    val summary: String,
    val description: String,
    val email: String,
    val userName: String,
)

data class BoardResponse(
    val id: Long,
    val summary: String,
    val description: String,
    val userId: String,
    val userName: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ")
    val createdDt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ")
    val updatedDt: LocalDateTime?,
) {
    companion object {
      operator fun invoke(board: Board) =
        with(board) {
          BoardResponse(
            id = id!!,
            summary = summary,
            description = description,
            userId = userId,
            userName = userName,
            createdDt = createdDt,
            updatedDt = updatedDt,
          )
        }
    }
}