package com.example.rickandmortyapp.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortyapp.databinding.ActivityCharacterDetailBinding

class CharacterDetailActivity: AppCompatActivity() {

    private lateinit var binding : ActivityCharacterDetailBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionId = intent.getIntExtra("characterId", 3)

        binding.characterDetailContainer.setOnClickListener {
            Toast.makeText(this, sessionId.toString(), Toast.LENGTH_SHORT)
        }
    }
}