package com.example.rickandmortyapp.data.network

import com.example.rickandmortyapp.core.RetrofitHelper
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.Characters
import com.example.rickandmortyapp.data.model.Episode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class RickAndMortyService {

    private val retrofit: Retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCharacter(id: Int): Character {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RickAndMortyApiClient::class.java).getCharacter(id)
            response.body() ?: Character(0,"", "", "", "", "")
        }
    }

    suspend fun getCharacters(page: Int): Characters {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RickAndMortyApiClient::class.java).getCharacters(page)
            response.body() ?: Characters(emptyList())
        }
    }

    suspend fun getCharactersByEpisodes(characters: String): List<Character> {
        return withContext((Dispatchers.IO)) {
            val response = retrofit.create(RickAndMortyApiClient::class.java).getCharactersByEpisodes(characters)
            response.body() ?: emptyList()
        }
    }

    suspend fun getEpisodes(episodes: String): List<Episode> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RickAndMortyApiClient::class.java).getEpisodes(episodes)
            response.body() ?: emptyList()
        }
    }
}