package com.example.rickandmortyapp.ui.view

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.adapter.CharactersAdapter
import com.example.rickandmortyapp.databinding.ActivityCharacterDetailBinding
import com.example.rickandmortyapp.ui.viewmodel.CharactersViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailActivity: AppCompatActivity() {

    private lateinit var binding : ActivityCharacterDetailBinding;
    private val charactersViewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionId = intent.getIntExtra("characterId", 3)

        charactersViewModel.onCreateCharacter(sessionId)

        // Refactor
        binding.myToolbar.setOnMenuItemClickListener {menuItem ->
            when(menuItem.itemId) {
                R.id.backButton -> {
                    startActivity(Intent(this, CharacterActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                    false
                }
                else -> {
                    false
                }
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.page_2 -> {
                    startActivity(Intent(this, CharacterActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    false
                }
                R.id.page_3 -> {
                    startActivity(Intent(this, EpisodeActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    false
                }

                else -> {
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    startActivity(Intent(this, HomeActivity::class.java))
                    false
                }
            }
        }

        charactersViewModel.characterModel.observe(this, Observer {
            Picasso.get().load(it.image).into(binding.characterDetailImage)
            binding.characterDetailName.text = it.name
            binding.characterDetailStatus.text = it.status
            binding.characterDetailSpecie.text = it.species
            binding.characterDetailOrigin.text = it.origin.name
            binding.characterDetailGender.text = it.gender
            binding.characterDetailLocation.text = it.location.name
        })

        charactersViewModel.isLoading.observe(this, {
            binding.progressBarCharacter.isVisible = it
        })
    }
}