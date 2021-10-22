package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.data.model.*
import com.example.rickandmortyapp.data.network.RickAndMortyService

class RickAndMortyRepository {

    private val api = RickAndMortyService()

    suspend fun getCharacter(id: Int): Character {
        val response = api.getCharacter(id)
        CharacterProvider.character = response
        return response;
    }

    suspend fun getCharacters(page: Int): Characters {
        val response = api.getCharacters(page)
        CharactersProvider.characters = response
        return response;
    }

    suspend fun getCharactersByEpisode(characters: String): List<Character> {
        val response = api.getCharactersByEpisodes(characters)
        CharactersByEpisodeProvider.charactersByEpisode = response
        return response
    }

    suspend fun getEpisodes(episodes: String): List<Episode> {
        val response = api.getEpisodes(episodes)
        EpisodesProvider.episodes = response
        return response
    }
}