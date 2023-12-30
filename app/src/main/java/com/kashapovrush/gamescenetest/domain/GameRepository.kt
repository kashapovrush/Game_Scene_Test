package com.kashapovrush.gamescenetest.domain

import android.widget.Chronometer
import android.widget.ImageView
import android.widget.TextView

interface GameRepository {

    fun setRandomImages(images: MutableList<Int>, buttons: Array<ImageView>)

    fun setTimingGame(
        chronometer: Chronometer,
        setVisibilityText: () -> Unit,
        setCountScore: (Int) -> Unit
    ): Int
}