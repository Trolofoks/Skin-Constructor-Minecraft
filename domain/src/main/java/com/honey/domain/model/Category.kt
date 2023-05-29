package com.honey.domain.model

sealed class Category{
    object Head : Category()
    object Body : Category()
    object Legs : Category()
}
