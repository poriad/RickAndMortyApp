package com.example.rickandmortyapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.model.Episode
import com.example.rickandmortyapp.domain.GetEpisodesSeasonFourUseCase
import com.example.rickandmortyapp.domain.GetEpisodesSeasonOneUseCase
import com.example.rickandmortyapp.domain.GetEpisodesSeasonThreeUseCase
import com.example.rickandmortyapp.domain.GetEpisodesSeasonTwoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val episodesSeasonOneUseCase: GetEpisodesSeasonOneUseCase,
    private val episodesSeasonTwoUseCase: GetEpisodesSeasonTwoUseCase,
    private val episodesSeasonThreeUseCase: GetEpisodesSeasonThreeUseCase,
    private val episodesSeasonFourUseCase: GetEpisodesSeasonFourUseCase
): ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    var episodesData = MutableLiveData<List<Episode>>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = episodesSeasonOneUseCase()

            if (result != null) {
                episodesData.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun onTabClick(tabPosition: Int) {
        viewModelScope.launch {
            val result: List<Episode>
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