package com.example.rickandmortyapp.data.model.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.model.Episode
import com.example.rickandmortyapp.databinding.EpisodeCardBinding

class EpisodesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var binding = EpisodeCardBinding.bind(view)

    fun bind(episode: Episode) {
        binding.episodeTitle.text = episode.name
        binding.episodeNumber.text = episode.episode
    }
}