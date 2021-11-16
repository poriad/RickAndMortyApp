package com.example.rickandmortyapp.data.model.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.databinding.CharactersByEpisodeCardBinding
import com.squareup.picasso.Picasso

class CharactersByEpisodeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var binding = CharactersByEpisodeCardBinding.bind(view)

    fun bind(character: Character) {
        Picasso.get().load(character.image).into(binding.characterImage)
        binding.episodeCharacterName.text = character.name
    }
}