package com.example.rickandmortyapp.ui.view

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.adapter.CharactersAdapter
import com.example.rickandmortyapp.data.model.adapter.CharactersByEpisodeAdapter
import com.example.rickandmortyapp.databinding.ActivityEpisodeDetailBinding
import com.example.rickandmortyapp.ui.viewmodel.EpisodeViewModel

class EpisodeDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEpisodeDetailBinding
    private lateinit var adapter: CharactersByEpisodeAdapter
    private val episodeDetailViewModel : EpisodeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEpisodeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val characterArray= intent.getStringArrayExtra("episodeArray") as Array<String>

        var result = ""
        characterArray.map { characterURL ->
            result += characterURL.filter {
                it.isDigit()
            } + ","
        }

        binding.episodeDetail.paintFlags = Paint.UNDERLINE_TEXT_FLAG;

        episodeDetailViewModel.onCreate(result)

        episodeDetailViewModel.charactersByEpisode.observe(this, {
            adapter = CharactersByEpisodeAdapter(it)
            binding.episodeWithCharactersRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.episodeWithCharactersRecyclerView.adapter = adapter
        })

    }
}