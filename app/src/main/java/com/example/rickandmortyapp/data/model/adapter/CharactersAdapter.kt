package com.example.rickandmortyapp.data.model.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.holder.CharactersViewHolder
import com.example.rickandmortyapp.ui.view.CharacterDetailActivity
import com.example.rickandmortyapp.ui.view.EpisodeActivity


class CharactersAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharactersViewHolder>() {
    private var contextParent: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextParent = parent.context
        return CharactersViewHolder(layoutInflater.inflate(R.layout.character_card, parent, false))
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        var item = characters[position]
        holder.itemView.setOnClickListener {
            val switchActivityIntent = Intent(contextParent, CharacterDetailActivity::class.java)
            switchActivityIntent.putExtra("characterId", characters[position].id)
            startActivity(contextParent!!, switchActivityIntent, null)
            Toast.makeText(contextParent, characters[position].name, Toast.LENGTH_SHORT).show()
        }
        return holder.bind(item)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}