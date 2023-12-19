package com.kashapovrush.gamescenetest.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kashapovrush.gamescenetest.R
import com.kashapovrush.gamescenetest.databinding.ActivityGameBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = mutableListOf(
            R.drawable.game1, R.drawable.game1,
            R.drawable.game2, R.drawable.game2,
            R.drawable.game3, R.drawable.game3,
            R.drawable.game4, R.drawable.game4,
            R.drawable.game5, R.drawable.game5,
            R.drawable.game6, R.drawable.game6,
            R.drawable.game7, R.drawable.game7,
            R.drawable.game8, R.drawable.game8,
            R.drawable.game9, R.drawable.game9,
            R.drawable.game10, R.drawable.game10,

            )

        val buttons = arrayOf(
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
            binding.button10,
            binding.button11,
            binding.button12,
            binding.button13,
            binding.button14,
            binding.button15,
            binding.button16,
            binding.button17,
            binding.button18,
            binding.button19,
            binding.button20,
        )

        images.shuffle()



        for (i in 0..19) {
            buttons[i].setImageResource(images[i])
        }

        setTiming()
    }


    private fun setTiming() {
        var count: Int = 100


        binding.endOfTimeWarning.setOnClickListener {
            startActivity(GameOverActivity.newIntent(this))
        }


        with(binding.gameTiming) { ->
            base = SystemClock.elapsedRealtime()
            this.start()
        }

        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            runOnUiThread {
                binding.endOfTimeWarning.visibility = View.VISIBLE
            }
            delay(11000)

            while (true) {
                if (count > 10) {
                    count -= 5
                }

                runOnUiThread {
                    binding.count.text = count.toString()
                }
                delay(1000)
            }

        }
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, GameActivity::class.java)
        }
    }
}