package com.example.rickandmortyapp.domain

import com.example.rickandmortyapp.data.RickAndMortyRepository
import javax.inject.Inject

class GetEpisodesSeasonOneUseCase @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
){
    suspend operator fun invoke() = rickAndMortyRepository.getEpisodes("1,2,3,4,5,6,7,8,9,10,11")
}