package com.kashapovrush.gamescenetest.domain

import android.widget.ImageView

interface GameRepository {

    fun setRandomImages(images: MutableList<Int>, buttons: Array<ImageView>)
}