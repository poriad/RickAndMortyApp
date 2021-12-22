package com.example.rickandmortyapp.data.model.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.databinding.CharacterCardBinding
import com.example.rickandmortyapp.data.model.Character
import com.squareup.picasso.Picasso

class CharactersViewHolder(view: View) :RecyclerView.ViewHolder(view) {

    private var binding = CharacterCardBinding.bind(view)

    fun bind(character: Character) {
        val characterState = character.status + " - " + character.species
        binding.characterSpecie.text = character.name
        binding.characterState.text = characterState.capitalize()
        binding.lastLocationTwo.text = character.location.name
        Picasso.get().load(character.image).into(binding.characterImage)
    }
}