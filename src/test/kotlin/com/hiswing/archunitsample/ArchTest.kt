package com.hiswing.archunitsample

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ArchTest {
    @Nested
    inner class `アーキテクチャをテストするサンプル` {
        @Test
        fun `api配下はControllerである`() {
            val doNotIncludeTest = ImportOption.DoNotIncludeTests()
            val importedClasses = ClassFileImporter().withImportOption(doNotIncludeTest).importPackages("com.hiswing.archunitsample")
            println("testPrint:$importedClasses")
        }
    }
}