package com.example.rickandmortyapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Refactor
        supportActionBar?.setHomeAsUpIndicator(R.mipmap.rick)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Refactor
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.page_2 -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    false
                }
                R.id.page_3 -> {
                    startActivity(Intent(this, EpisodeActivity::class.java))
                    false
                }

                else -> {
                    false
                }
            }
        }
    }
}