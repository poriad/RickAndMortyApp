package com.example.rickandmortyapp.data.model.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.holder.CharactersViewHolder
import com.example.rickandmortyapp.ui.view.CharacterDetailActivity


class CharactersAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharactersViewHolder>() {
    private var contextParent: Context? = null
    private lateinit var stateCharacter: ImageView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextParent = parent.context
        return CharactersViewHolder(layoutInflater.inflate(R.layout.character_card, parent, false))
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        stateCharacter = holder.itemView.findViewById(R.id.characterStateCircle)
        val item = characters[position]
        holder.itemView.setOnClickListener {
            val switchActivityIntent = Intent(contextParent, CharacterDetailActivity::class.java)
            switchActivityIntent.putExtra("characterId", characters[position].id)
            startActivity(contextParent!!, switchActivityIntent, null)
        }

        if (characters[position].status == "Alive") {
            stateCharacter.setBackgroundResource(R.drawable.circle_green)
        }

        if (characters[position].status == "Dead") {
            stateCharacter.setBackgroundResource(R.drawable.circle_red)
        }

        if (characters[position].status == "unknown") {
            stateCharacter.setBackgroundResource(R.drawable.circle)
        }
        return holder.bind(item)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}