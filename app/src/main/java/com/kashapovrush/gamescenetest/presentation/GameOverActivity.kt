package com.kashapovrush.gamescenetest.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import com.kashapovrush.gamescenetest.R
import com.kashapovrush.gamescenetest.databinding.ActivityGameOverBinding

class GameOverActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameOverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameOverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = requireNotNull(intent.getIntExtra("KEY", 0))
        binding.score.text = score.toString()
        if (score == 100) {
            binding.textWon.text = "[GREAT! YOU WON!]"
            binding.finishedText.text = "[CONGRATULATION!]"
        } else if (score in 50..99) {
            binding.cup.visibility = View.GONE
            binding.textWon.text = "[GOOD RESULT]"
            binding.finishedText.text = "[VERY GOOD]"
        } else {
            binding.cup.visibility = View.GONE
            binding.finishedText.text = "[FINISHED]"
            binding.textWon.text = "[BAD RESULT]"
        }

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