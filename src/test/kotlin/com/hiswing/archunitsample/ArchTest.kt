package com.hiswing.archunitsample

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
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
        @Test
        fun `usecaseはapi配下以外に依存しない`() {
            val importedClasses = ClassFileImporter().importPackages("com.hiswing.archunitsample.api")
            val rule: ArchRule = noClasses().that().resideInAPackage("..usecase..")
                .should().dependOnClassesThat().resideInAPackage("..api..")
            rule.check(importedClasses)
        }
    }
}