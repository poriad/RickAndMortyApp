package com.example.rickandmortyapp.ui.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.adapter.CharactersAdapter
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.ui.viewmodel.CharactersViewModel
import com.example.rickandmortyapp.ui.viewmodel.CharactersViewModel.Companion.characterPage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharactersAdapter
    private val charactersViewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menuConfig()
        actionsConfig()
    }

    private fun menuConfig() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.page_1 -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                    false
                }
                R.id.page_3 -> {
                    startActivity(Intent(this, EpisodeActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    false
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun actionsConfig() {
        binding.leftPageId.isEnabled = false
        if (characterPage == 1) {
            binding.leftPageId.alpha = 0.5F
        }

        binding.rightPageId.setOnClickListener {
            characterPage++
            charactersViewModel.onClick()
            val characterPageString = "$characterPage Of 34"
            binding.pageNumber.text = characterPageString
            binding.leftPageId.isEnabled = characterPage != 1
            if (characterPage > 1 ) {
                binding.leftPageId.alpha = 1F
            }

            if (characterPage == 34) {
                binding.rightPageId.alpha = 0.5F
            }
            binding.rightPageId.isEnabled = characterPage != 34

        }

        binding.leftPageId.setOnClickListener {
            characterPage--
            charactersViewModel.onClick()
            val characterPageString = "$characterPage Of 34"
            binding.pageNumber.text = characterPageString
            if (characterPage == 1) {
                binding.leftPageId.isEnabled = false
                binding.leftPageId.alpha = 0.5F
            } else {
                binding.leftPageId.alpha = 1F
            }

            if (characterPage < 34) {
                binding.rightPageId.isEnabled = true
                binding.rightPageId.alpha = 1F
            }
        }

        charactersViewModel.isLoading.observe(this, {
            binding.progressBar.isVisible = it
        })

        charactersViewModel.onCreate()
        charactersViewModel.charactersModel.observe(this, {
            adapter = CharactersAdapter(it)
            binding.characterRecicler.layoutManager = LinearLayoutManager(this)
            binding.characterRecicler.adapter = adapter
        })
    }
}