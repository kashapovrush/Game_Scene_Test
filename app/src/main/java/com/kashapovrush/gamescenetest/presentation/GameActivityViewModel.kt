package com.kashapovrush.gamescenetest.presentation

import android.widget.Chronometer
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.kashapovrush.gamescenetest.domain.SetRandomImagesUseCase
import com.kashapovrush.gamescenetest.domain.SetTimingGameUseCase
import javax.inject.Inject

class GameActivityViewModel @Inject constructor(
    private val setRandomImagesUseCase: SetRandomImagesUseCase,
    private val setTimingGameUseCase: SetTimingGameUseCase
) : ViewModel() {

    fun setRandomImages(images: MutableList<Int>, buttons: Array<ImageView>) {
        setRandomImagesUseCase(images, buttons)
    }

    fun setTimingGame(
        chronometer: Chronometer,
        setVisibilityText: () -> Unit,
        setCountScore: (Int) -> Unit
    ): Int {
       return setTimingGameUseCase(chronometer, setVisibilityText, setCountScore)
    }
}