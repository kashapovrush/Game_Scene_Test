package com.kashapovrush.gamescenetest.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kashapovrush.gamescenetest.R

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, GameActivity::class.java)
        }
    }
}