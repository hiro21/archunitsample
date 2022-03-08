package com.hiswing.archunitsample.usecase

import com.hiswing.archunitsample.domain.PrintTimeJapan
import org.springframework.stereotype.Component

@Component
class HelloUsecase(
    private val printTime: PrintTimeJapan
) {
    fun fetch(): String {
        printTime.print()
        return "hello"
    }
}