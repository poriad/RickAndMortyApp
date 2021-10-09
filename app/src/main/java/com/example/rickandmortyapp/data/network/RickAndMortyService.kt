package com.example.rickandmortyapp.data.network

import com.example.rickandmortyapp.core.RetrofitHelper
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.Characters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class RickAndMortyService {

    private val retrofit: Retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCharacter(): Character {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RickAndMortyApiClient::class.java).getCharacter()
            response.body() ?: Character(0,"", "", "", "", "")
        }
    }

    suspend fun getCharacters(page: Int): Characters {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RickAndMortyApiClient::class.java).getCharacters(page)
            response.body() ?: Characters(emptyList())
        }
    }


}