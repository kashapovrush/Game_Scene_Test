package com.kashapovrush.gamescenetest.data.repository

import android.widget.ImageView
import com.kashapovrush.gamescenetest.domain.GameRepository
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(): GameRepository {


    override fun setRandomImages(images: MutableList<Int>, buttons: Array<ImageView>) {
        images.shuffle()

        images.forEachIndexed { index, _ ->
            buttons[index].setImageResource(images[index])
        }
    }
}