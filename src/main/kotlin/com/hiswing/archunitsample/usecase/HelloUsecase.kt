package com.hiswing.archunitsample.usecase

import org.springframework.stereotype.Component

@Component
class HelloUsecase {
    fun fetch(): String {
        return "hello"
    }
}