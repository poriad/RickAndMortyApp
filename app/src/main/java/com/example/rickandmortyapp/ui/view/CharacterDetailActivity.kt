package com.example.rickandmortyapp.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.data.model.adapter.CharactersAdapter
import com.example.rickandmortyapp.databinding.ActivityCharacterDetailBinding
import com.example.rickandmortyapp.ui.viewmodel.CharacterViewModel
import com.squareup.picasso.Picasso

class CharacterDetailActivity: AppCompatActivity() {

    private lateinit var binding : ActivityCharacterDetailBinding;
    private lateinit var adapter: CharactersAdapter
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionId = intent.getIntExtra("characterId", 3)

        characterViewModel.onCreateCharacter(sessionId)

        characterViewModel.characterModel.observe(this, Observer {
            Picasso.get().load(it.image).into(binding.characterDetailImage)
            binding.characterDetailName.text = it.name
            binding.characterDetailStatus.text = it.status
            binding.characterDetailSpecie.text = it.species
            binding.characterDetailOrigin.text = it.gender

        })

        characterViewModel.isLoading.observe(this, {
            binding.progressBarCharacter.isVisible = it
        })
    }
}