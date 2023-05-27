package com.honey.skinconstructorminecraft.di

import com.honey.skinconstructorminecraft.ui.screen.constructor.ConstructorViewModel
import com.honey.skinconstructorminecraft.ui.screen.greeting.GreetingViewModel
import org.koin.dsl.module

val appModule = module {
    factory<GreetingViewModel> {
        GreetingViewModel()
    }

    factory<ConstructorViewModel> {
        ConstructorViewModel()
    }
}