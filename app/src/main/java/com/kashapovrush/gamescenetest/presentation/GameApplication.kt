package com.kashapovrush.gamescenetest.presentation

import android.app.Application
import com.kashapovrush.gamescenetest.di.DaggerApplicationComponent

class GameApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create()
    }
}