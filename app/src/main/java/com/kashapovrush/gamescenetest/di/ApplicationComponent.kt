package com.kashapovrush.gamescenetest.di

import com.kashapovrush.gamescenetest.presentation.GameActivity
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {


    fun inject(gameActivity: GameActivity)

    @Component.Factory
    interface Factory {

        fun create(): ApplicationComponent
    }
}