package com.example.rickandmortyapp.data.model.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.holder.CharactersByEpisodeViewHolder

class CharactersByEpisodeAdapter(private val characters: List<Character>): RecyclerView.Adapter<CharactersByEpisodeViewHolder>() {
    private var contextParent: Context? = null
    lateinit var fImageButton: ImageView
    lateinit var characterName: TextView
    lateinit var episodeCard: CardView
    private var positionMark: Int = 30000

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersByEpisodeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextParent = parent.context
        return CharactersByEpisodeViewHolder(layoutInflater.inflate(R.layout.characters_by_episode_card, parent, false))
    }

    override fun onBindViewHolder(holder: CharactersByEpisodeViewHolder, position: Int) {
        episodeCard = holder.itemView.findViewById(R.id.episodeCardDetail)
        fImageButton = holder.itemView.findViewById(R.id.episodeCharacterImageDetail)
        characterName = holder.itemView.findViewById(R.id.episodeCharacterNameDetail)

        val item = characters[position]
        fImageButton.setOnClickListener {
            if (positionMark == position) {
                positionMark = 30000
                notifyDataSetChanged()
            } else {
                positionMark = position
                notifyDataSetChanged()
            }
        }

        if (positionMark == position) {
            fImageButton.alpha = 0.4F
            characterName.alpha = 1F
        }

        if (positionMark != position) {
            fImageButton.alpha = 1F
            characterName.alpha = 0F
        }
        return holder.bind(item)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

}