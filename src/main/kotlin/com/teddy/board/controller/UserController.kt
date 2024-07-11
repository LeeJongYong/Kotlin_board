package com.teddy.board.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class UserController {

    @GetMapping("/user")
    fun signIn(): String {
        return "Sign In"
    }

}