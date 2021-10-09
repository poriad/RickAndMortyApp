package com.example.rickandmortyapp.data.model.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.databinding.CharacterCardBinding
import com.example.rickandmortyapp.data.model.Character
import com.squareup.picasso.Picasso

class CharactersViewHolder(view: View) :RecyclerView.ViewHolder(view) {

    private var binding = CharacterCardBinding.bind(view)

    fun bind(character: Character) {
            binding.characterSpecie.text = character.name
            Picasso.get().load(character.image).into(binding.characterImage)
    }
}