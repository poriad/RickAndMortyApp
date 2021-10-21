package com.example.rickandmortyapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.adapter.EpisodesAdapter
import com.example.rickandmortyapp.databinding.ActivityEpisodeBinding
import com.example.rickandmortyapp.ui.viewmodel.EpisodesViewModel
import com.google.android.material.tabs.TabLayout

class EpisodeActivity: AppCompatActivity() {
    private lateinit var adapter : EpisodesAdapter
    private lateinit var binding : ActivityEpisodeBinding;
    private val episodeViewModel : EpisodesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        super.onCreate(savedInstanceState)

        binding = ActivityEpisodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setHomeAsUpIndicator(R.mipmap.rick)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        episodeViewModel.isLoading.observe(this, {
            binding.progressBarEpisode.isVisible = it
        })

        episodeViewModel.onCreate()

        episodeViewModel.episodesData.observe(this, {
            adapter = EpisodesAdapter(it)
            binding.episodesRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.episodesRecyclerView.adapter = adapter
        })

        binding.tabBarEpisodes.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position) {
                    0 -> {
                        episodeViewModel.onTabClick(0)
                    }
                    1 -> {
                        episodeViewModel.onTabClick(1)
                    }
                    2 -> {
                        episodeViewModel.onTabClick(2)
                    }
                    else -> {
                        episodeViewModel.onTabClick(3)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })


        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.page_1 -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    false
                }
                R.id.page_2 -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    false
                }

                else -> {
                    false
                }
            }
        }
    }
}