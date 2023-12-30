package com.kashapovrush.gamescenetest.domain

import android.widget.Chronometer
import javax.inject.Inject

class SetTimingGameUseCase @Inject constructor(private val repository: GameRepository) {

    operator fun invoke(
        chronometer: Chronometer,
        setVisibilityText: () -> Unit,
        setCountScore: (Int) -> Unit
    ): Int {
        return repository.setTimingGame(chronometer, setVisibilityText, setCountScore)
    }
}