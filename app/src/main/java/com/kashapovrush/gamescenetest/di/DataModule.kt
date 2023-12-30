package com.kashapovrush.gamescenetest.di

import com.kashapovrush.gamescenetest.data.repository.GameRepositoryImpl
import com.kashapovrush.gamescenetest.domain.GameRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindGameRepository(impl: GameRepositoryImpl): GameRepository
}