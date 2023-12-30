package com.kashapovrush.gamescenetest.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kashapovrush.gamescenetest.R
import com.kashapovrush.gamescenetest.databinding.ActivityGameBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private lateinit var viewModel: GameActivityViewModel
    private var value = 100

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as GameApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory)[GameActivityViewModel::class.java]

        val images = imagesList()
        val buttons = buttonsList()
        viewModel.setRandomImages(images, buttons)

        val listBufferForImages = mutableListOf<Int>()
        val listBufferForButtons = mutableListOf<ImageView>()
        var count = 0

        value = viewModel.setTimingGame(
            setVisibilityText = {
                runOnUiThread {
                    binding.endOfTimeWarning.visibility = View.VISIBLE
                }
            },
            chronometer = binding.gameTiming,
            setCountScore = {
                runOnUiThread {
                    value -= 5
                    binding.count.text = it.toString()
                }
            }
        )

        for (i in 0..19) {

            buttons[i].setOnClickListener {
                buttons.forEachIndexed { index, _ ->
                    buttons[index].background = getDrawable(R.drawable.background_card_game)
                }
                buttons[i].background = getDrawable(R.drawable.background_card_blue)
                listBufferForImages.add(images[i])
                listBufferForButtons.add(buttons[i])

                if (count < 100) {

                    if (listBufferForImages.size == 2) {
                        if (listBufferForImages[0] == listBufferForImages[1] && listBufferForButtons[0] != listBufferForButtons[1]) {
                            buttons[i].background = getDrawable(R.drawable.background_card_green)
                            buttons[i].setImageResource(R.drawable.background_card_game)

                            buttons[i].isEnabled = false
                            count++
                            images.forEachIndexed { index, _ ->
                                if (images[index] == images[i]) {
                                    buttons[index].setImageResource(R.drawable.background_card_game)
                                    buttons[index].background =
                                        getDrawable(R.drawable.background_card_green)
                                    buttons[index].isEnabled = false
                                    listBufferForImages.clear()
                                    listBufferForButtons.clear()
                                    if (count == 10) {
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
                            buttons[i].background = getDrawable(R.drawable.background_card_red)
                            listBufferForButtons[0].background =
                                getDrawable(R.drawable.background_card_red)

                            listBufferForButtons.clear()
                            listBufferForImages.clear()
                        }
                        listBufferForImages.clear()
                    }
                }
            }


        }

    }

    private fun imagesList(): MutableList<Int> {
        return mutableListOf(
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
    }

    private fun buttonsList(): Array<ImageView> {
        return arrayOf(
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
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, GameActivity::class.java)
        }
    }
}