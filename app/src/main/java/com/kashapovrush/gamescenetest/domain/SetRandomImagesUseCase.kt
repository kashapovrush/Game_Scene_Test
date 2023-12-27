package com.kashapovrush.gamescenetest.domain

import android.widget.ImageView
import javax.inject.Inject

class SetRandomImagesUseCase @Inject constructor(private val repository: GameRepository){

    operator fun invoke(images: MutableList<Int>, buttons: Array<ImageView>) {
        repository.setRandomImages(images, buttons)
    }
}