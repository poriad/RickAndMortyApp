package com.example.rickandmortyapp.data.model.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.holder.CharactersByEpisodeViewHolder

class CharactersByEpisodeAdapter(private val characters: List<Character>): RecyclerView.Adapter<CharactersByEpisodeViewHolder>() {
    private var contextParent: Context? = null
    lateinit var fImageButton: ImageView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersByEpisodeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextParent = parent.context
        return CharactersByEpisodeViewHolder(layoutInflater.inflate(R.layout.characters_by_episode_card, parent, false))
    }

    override fun onBindViewHolder(holder: CharactersByEpisodeViewHolder, position: Int) {
        fImageButton = holder.itemView.findViewById(R.id.characterImage)

        val item = characters[position]
        fImageButton.setOnClickListener {
            it.alpha = 0.5F
        }
        return holder.bind(item)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

}