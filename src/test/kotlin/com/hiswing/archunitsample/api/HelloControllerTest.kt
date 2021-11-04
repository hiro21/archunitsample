package com.hiswing.archunitsample.api

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class HelloControllerTest {
    @Nested
    inner class `hello APIを呼び出す` {
        @Test
        fun `helloエンドポイントにアクセスされたらhelloを返す`() {
            val controller = HelloController()
            val result: String = controller.hello()
            assertEquals("hello", result)
        }
    }
}