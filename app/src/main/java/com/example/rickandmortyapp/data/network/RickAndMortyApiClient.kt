package com.example.rickandmortyapp.data.network

import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.Characters
import com.example.rickandmortyapp.data.model.Episode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiClient {

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Response<Characters>

    @GET("episode/{episodes}")
    suspend fun getEpisodes(@Path("episodes") episodes: String): Response<List<Episode>>
}