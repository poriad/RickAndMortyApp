package com.example.rickandmortyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.model.Episode
import com.example.rickandmortyapp.domain.GetEpisodesSeasonFourUseCase
import com.example.rickandmortyapp.domain.GetEpisodesSeasonOneUseCase
import com.example.rickandmortyapp.domain.GetEpisodesSeasonThreeUseCase
import com.example.rickandmortyapp.domain.GetEpisodesSeasonTwoUseCase
import kotlinx.coroutines.launch

class EpisodesViewModel: ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    var episodesSeasonOneUseCase = GetEpisodesSeasonOneUseCase()
    var episodesSeasonTwoUseCase = GetEpisodesSeasonTwoUseCase()
    var episodesSeasonThreeUseCase = GetEpisodesSeasonThreeUseCase()
    var episodesSeasonFourUseCase = GetEpisodesSeasonFourUseCase()
    var episodesData = MutableLiveData<List<Episode>>()



    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            var result = episodesSeasonOneUseCase()

            if (result != null) {
                episodesData.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun onTabClick(tabPosition: Int) {
        viewModelScope.launch {
            var result: List<Episode>
            isLoading.postValue(true)
            when (tabPosition) {
                0 -> {
                    result = episodesSeasonOneUseCase()
                }
                1 -> {
                    result = episodesSeasonTwoUseCase()
                }
                2 -> {
                    result = episodesSeasonThreeUseCase()
                }
                else -> {
                    result = episodesSeasonFourUseCase()
                }
            }

            if (result != null) {
                episodesData.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}