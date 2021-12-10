package com.example.rickandmortyapp.ui.view

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.adapter.CharactersByEpisodeAdapter
import com.example.rickandmortyapp.databinding.ActivityEpisodeDetailBinding
import com.example.rickandmortyapp.ui.viewmodel.EpisodeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEpisodeDetailBinding
    private lateinit var adapter: CharactersByEpisodeAdapter
    private val episodeDetailViewModel : EpisodeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEpisodeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val characterArray = intent.getStringArrayExtra("episodeArray") as Array<String>
        val episodeName = intent.getStringExtra("episodeName")
        val episodeDate = intent.getStringExtra("episodeDate")
        val episodeNumber = intent.getStringExtra("episodeNumber")

        binding.episodeDate.text = episodeDate
        binding.episodeName.text = episodeName
        binding.episodeNumber.text = episodeNumber

        var result = ""
        characterArray.map { characterURL ->
            result += characterURL.filter {
                it.isDigit()
            } + ","
        }

        // Refactor
        binding.myToolbar.setOnMenuItemClickListener {menuItem ->
            when(menuItem.itemId) {
                R.id.backButton -> {
                    startActivity(Intent(this, EpisodeActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                    false
                }
                else -> {
                    false
                }
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.page_1 -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                    false
                }
                R.id.page_2 -> {
                    startActivity(Intent(this, CharacterActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                    false
                }

                R.id.page_3 -> {
                    startActivity(Intent(this, EpisodeActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                    false
                }
                else -> {
                    false
                }
            }
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