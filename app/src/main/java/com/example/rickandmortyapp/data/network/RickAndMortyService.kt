package com.example.rickandmortyapp.data.network

import com.example.rickandmortyapp.core.RetrofitHelper
import com.example.rickandmortyapp.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class RickAndMortyService @Inject constructor(
    private val api: RickAndMortyApiClient
) {

    suspend fun getCharacter(id: Int): Character {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacter(id)
            response.body() ?: Character(0,"", "", "", "", "", Location(""), Origin(""))
        }
    }

    suspend fun getCharacters(page: Int): Characters {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacters(page)
            response.body() ?: Characters(emptyList())
        }
    }

    suspend fun getCharactersByEpisodes(characters: String): List<Character> {
        return withContext((Dispatchers.IO)) {
            val response = api.getCharactersByEpisodes(characters)
            response.body() ?: emptyList()
        }
    }

    suspend fun getEpisodes(episodes: String): List<Episode> {
        return withContext(Dispatchers.IO) {
            val response = api.getEpisodes(episodes)
            response.body() ?: emptyList()
        }
    }
}