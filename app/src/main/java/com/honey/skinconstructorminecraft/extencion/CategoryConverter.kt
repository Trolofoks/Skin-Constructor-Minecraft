package com.honey.skinconstructorminecraft.extencion

import com.honey.domain.model.Category
import com.honey.skinconstructorminecraft.model.AppCategory

fun Category.toApp(): AppCategory{
    return when(this){
        Category.Head -> {AppCategory.HEAD}
        Category.Body -> {AppCategory.BODY}
        Category.Legs -> {AppCategory.LEGS}
    }
}

fun AppCategory.toDomain(): Category{
    return when(this){
        AppCategory.HEAD -> {Category.Head}
        AppCategory.BODY -> {Category.Body}
        AppCategory.LEGS -> {Category.Legs}
    }
}