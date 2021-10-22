package com.example.rickandmortyapp.data.model.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.Episode
import com.example.rickandmortyapp.data.model.holder.EpisodesViewHolder
import com.example.rickandmortyapp.ui.view.CharacterDetailActivity
import com.example.rickandmortyapp.ui.view.EpisodeDetailActivity

class EpisodesAdapter(private val episodes: List<Episode>) : RecyclerView.Adapter<EpisodesViewHolder>() {
    private var contextParent: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextParent = parent.context
        return EpisodesViewHolder(layoutInflater.inflate(R.layout.episode_card, parent, false))
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        var item = episodes[position]
        holder.itemView.setOnClickListener {
            val switchActivityIntent = Intent(contextParent, EpisodeDetailActivity::class.java)
            switchActivityIntent.putExtra("episodeId", item.id)
            switchActivityIntent.putExtra("episodeArray", item.characters)
            ContextCompat.startActivity(contextParent!!, switchActivityIntent, null)
        }

        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return episodes.size
    }
}