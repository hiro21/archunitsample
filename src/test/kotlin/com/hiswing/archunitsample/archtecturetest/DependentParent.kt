package com.hiswing.archunitsample.archtecturetest

import com.hiswing.archunitsample.domain.PrintTimeJapan
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DependentParent {
    @Nested
    inner class `依存している親を確認する` {
        @Test
        fun `親を抽出する`() {
            val classes = ClassFileImporter()
                .withImportOption(ImportOption.DoNotIncludeTests())
                .importPackages("com.hiswing.archunitsample")
            val childClass = classes.get(PrintTimeJapan::class.java)
            val result: List<JavaClass> = extractParent(listOf(childClass))
            println(result)
        }
        private fun extractParent(javaClass: List<JavaClass>): List<JavaClass> {
            // まずはその子を抽出
            val parent: List<JavaClass> = javaClass.map {
                it.directDependenciesToSelf.map {
                    it.originClass
                }
            }.flatten().distinct()
            val parentSize = parent.filter { it.directDependenciesToSelf.size > 0 }.size
            if (parentSize == 0) {
                return parent
            } else {
                return extractParent(parent)
            }
        }
    }
}