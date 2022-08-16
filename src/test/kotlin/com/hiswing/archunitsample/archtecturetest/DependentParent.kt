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
            val dependentClass: List<JavaClass> = childClass.directDependenciesToSelf.map {
                it.originClass
            }.distinct()
            // println(dependentClass)

            val result: List<JavaClass> = dependentClass.map {
                it.directDependenciesToSelf.map {
                    it.originClass
                }
            }.flatten().distinct()
            println(result)

            val result2: List<JavaClass> = result.map {
                it.directDependenciesToSelf.map {
                    it.originClass
                }
            }.flatten().distinct()
            println(result2)
        }
    }
}