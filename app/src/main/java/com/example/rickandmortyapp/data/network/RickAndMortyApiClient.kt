package com.example.rickandmortyapp.data.network

import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.Characters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiClient {

    @GET("character/1")
    suspend fun getCharacter(): Response<Character>

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Response<Characters>

}