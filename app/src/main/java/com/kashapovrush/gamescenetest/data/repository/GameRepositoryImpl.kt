package com.kashapovrush.gamescenetest.data.repository

import android.widget.Chronometer
import android.widget.ImageView
import com.kashapovrush.gamescenetest.domain.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor() : GameRepository {


    override fun setRandomImages(images: MutableList<Int>, buttons: Array<ImageView>) {
        images.shuffle()

        images.forEachIndexed { index, _ ->
            buttons[index].setImageResource(images[index])
        }
    }

    override fun setTimingGame(
        chronometer: Chronometer,
        setVisibilityText: () -> Unit,
        setCountScore: (Int) -> Unit
    ): Int {
        with(chronometer) { ->
            base = android.os.SystemClock.elapsedRealtime()
            this.start()
        }

        var value = 100
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            setVisibilityText()
            delay(11000)

            while (true) {
                if (value > 10) {
                    value -= 5

                    setCountScore(value)
                    delay(1000)
                }


            }

        }
        return value
    }
}