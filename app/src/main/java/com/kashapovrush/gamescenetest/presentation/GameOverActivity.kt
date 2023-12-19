package com.kashapovrush.gamescenetest.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.kashapovrush.gamescenetest.R
import com.kashapovrush.gamescenetest.databinding.ActivityGameOverBinding

class GameOverActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameOverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameOverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDoubleReward.setOnClickListener {
            startActivity(GameActivity.newIntent(this))
        }

        binding.buttonToHome.setOnClickListener {
            startActivity(StartActivity.newIntent(this))
        }
    }

    companion object {
        fun newIntent(context: Context, value: Int): Intent {
            val intent = Intent(context, GameOverActivity::class.java)
            intent.putExtra("KEY", value)
            return intent
        }
    }
}