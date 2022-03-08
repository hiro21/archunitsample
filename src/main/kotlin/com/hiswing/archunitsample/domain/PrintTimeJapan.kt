package com.hiswing.archunitsample.domain

import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class PrintTimeJapan {
    fun print() {
        val now = LocalDateTime.now()
        println(now.toString())
    }
}