package com.kashapovrush.gamescenetest.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kashapovrush.gamescenetest.R

class GameOverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, GameOverActivity::class.java)
        }
    }
}