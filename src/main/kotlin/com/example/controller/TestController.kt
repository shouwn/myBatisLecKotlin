package com.example.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
class TestController {

    @GetMapping("test")
    fun test(): String{
        return "test"
    }
}