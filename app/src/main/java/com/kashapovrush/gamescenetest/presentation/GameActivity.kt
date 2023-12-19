package com.kashapovrush.gamescenetest.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.kashapovrush.gamescenetest.R
import com.kashapovrush.gamescenetest.databinding.ActivityGameBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private lateinit var imageView: ImageView
    private var value = 100

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

        images.forEachIndexed { index, _ ->
            buttons[index].setImageResource(images[index])
        }

        val list = mutableListOf<Int>()
        val listButtons = mutableListOf<ImageView>()
        var count = 0
        for (i in 0..19) {

            buttons[i].setOnClickListener {
                list.add(images[i])
                listButtons.add(buttons[i])

                if (count < 100) {

                    if (list.size == 2) {
                        if (list[0] == list[1] && listButtons[0] != listButtons[1]) {
                            buttons[i].setImageResource(R.drawable.background_card_game)
                            buttons[i].isEnabled = false
                            count++
                            images.forEachIndexed { index, _ ->
                                if (images[index] == images[i]) {
                                    buttons[index].setImageResource(R.drawable.background_card_game)
                                    buttons[index].isEnabled = false
                                    list.clear()
                                    listButtons.clear()
                                    if (count == 10) {
                                        Log.d("MainActivityTest", value.toString())
                                        startActivity(
                                            GameOverActivity.newIntent(
                                                this@GameActivity,
                                                value
                                            )
                                        )
                                    }
                                }
                            }
                        } else {
                            listButtons.clear()
                            list.clear()
                        }
                        list.clear()
                    }
                }
            }


        }


        setTiming()
    }


    private fun setTiming() {

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
                if (value > 10) {
                    value -= 5
                }

                runOnUiThread {
                    binding.count.text = value.toString()
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