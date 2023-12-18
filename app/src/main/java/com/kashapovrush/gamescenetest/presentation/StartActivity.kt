package com.kashapovrush.gamescenetest.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kashapovrush.gamescenetest.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStartGame.setOnClickListener {
            startActivity(GameActivity.newIntent(this))
        }
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, StartActivity::class.java)
        }
    }

}