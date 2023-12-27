package com.kashapovrush.gamescenetest.di

import androidx.lifecycle.ViewModel
import com.kashapovrush.gamescenetest.presentation.GameActivity
import com.kashapovrush.gamescenetest.presentation.GameActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GameActivityViewModel::class)
    fun bindGameActivityViewModel(viewModel: GameActivityViewModel): ViewModel
}