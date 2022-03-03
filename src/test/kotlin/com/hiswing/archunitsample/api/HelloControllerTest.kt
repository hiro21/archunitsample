package com.hiswing.archunitsample.api

import com.hiswing.archunitsample.usecase.HelloUsecase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class HelloControllerTest {
    @Nested
    inner class `hello APIを呼び出す` {
        @Test
        fun `helloエンドポイントにアクセスされたらhelloを返す`() {
            val usecase = HelloUsecase()
            val controller = HelloController(usecase)
            val result: String = controller.hello()
            assertEquals("hello", result)
        }
    }
}