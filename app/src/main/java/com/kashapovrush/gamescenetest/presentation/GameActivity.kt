package com.kashapovrush.gamescenetest.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kashapovrush.gamescenetest.R
import com.kashapovrush.gamescenetest.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.endOfTimeWarning.setOnClickListener {
            startActivity(GameOverActivity.newIntent(this))
        }
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, GameActivity::class.java)
        }
    }
}