package com.hiswing.archunitsample.api

import com.hiswing.archunitsample.domain.PrintTimeJapan
import com.hiswing.archunitsample.usecase.HelloUsecase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class HelloControllerTest {
    private val printTimeJapan = PrintTimeJapan()
    @Nested
    inner class `hello APIを呼び出す` {
        @Test
        fun `helloエンドポイントにアクセスされたらhelloを返す`() {
            val usecase = HelloUsecase(printTimeJapan)
            val controller = HelloController(usecase)
            val result: String = controller.hello()
            assertEquals("hello", result)
        }
    }
}