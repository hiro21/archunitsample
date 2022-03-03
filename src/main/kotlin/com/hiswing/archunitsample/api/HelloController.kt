package com.hiswing.archunitsample.api

import com.hiswing.archunitsample.usecase.HelloUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val usecase: HelloUsecase
) {
    @GetMapping("/hello")
    fun hello(): String {
        return usecase.fetch()
    }
}