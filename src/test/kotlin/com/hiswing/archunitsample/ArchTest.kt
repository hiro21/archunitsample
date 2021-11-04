package com.hiswing.archunitsample

import com.tngtech.archunit.core.importer.ClassFileImporter
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ArchTest {
    @Nested
    inner class `アーキテクチャをテストするサンプル` {
        @Test
        fun `api配下はControllerである`() {
            val importedClasses = ClassFileImporter().importPackages("com.hiswing.archunitsample")
            println(importedClasses)
        }
    }
}