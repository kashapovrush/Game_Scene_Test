package com.kashapovrush.gamescenetest.presentation

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.kashapovrush.gamescenetest.domain.SetRandomImagesUseCase
import javax.inject.Inject

class GameActivityViewModel @Inject constructor(
    private val setRandomImagesUseCase: SetRandomImagesUseCase
): ViewModel() {

    fun setRandomImages(images: MutableList<Int>, buttons: Array<ImageView>) {
        setRandomImagesUseCase(images, buttons)
    }
}