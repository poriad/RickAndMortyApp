package com.example.rickandmortyapp.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.adapter.EpisodesAdapter
import com.example.rickandmortyapp.databinding.ActivityEpisodeBinding
import com.example.rickandmortyapp.ui.viewmodel.EpisodesViewModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeActivity: AppCompatActivity() {
    private lateinit var adapter : EpisodesAdapter
    private lateinit var binding : ActivityEpisodeBinding
    private val episodeViewModel : EpisodesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEpisodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menuConfig()
        actionsConfig()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun menuConfig() {
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

                else -> {
                    false
                }
            }
        }
    }

    private fun actionsConfig() {
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

        episodeViewModel.isLoading.observe(this, {
            binding.progressBarEpisode.isVisible = it
        })

        episodeViewModel.onCreate()

        episodeViewModel.episodesData.observe(this, {
            adapter = EpisodesAdapter(it)
            binding.episodesRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.episodesRecyclerView.adapter = adapter
        })
    }
}