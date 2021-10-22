package com.example.rickandmortyapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.rickandmortyapp.data.model.adapter.CharactersAdapter
import com.example.rickandmortyapp.databinding.ActivityCharacterDetailBinding
import com.example.rickandmortyapp.ui.viewmodel.CharactersViewModel
import com.squareup.picasso.Picasso

class CharacterDetailActivity: AppCompatActivity() {

    private lateinit var binding : ActivityCharacterDetailBinding;
    private val charactersViewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionId = intent.getIntExtra("characterId", 3)

        charactersViewModel.onCreateCharacter(sessionId)

        charactersViewModel.characterModel.observe(this, Observer {
            Picasso.get().load(it.image).into(binding.characterDetailImage)
            binding.characterDetailName.text = it.name
            binding.characterDetailStatus.text = it.status
            binding.characterDetailSpecie.text = it.species
            binding.characterDetailOrigin.text = it.gender

        })

        charactersViewModel.isLoading.observe(this, {
            binding.progressBarCharacter.isVisible = it
        })
    }
}