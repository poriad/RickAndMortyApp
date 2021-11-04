package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.data.model.*
import com.example.rickandmortyapp.data.network.RickAndMortyService
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val api: RickAndMortyService,
    private val episodesProvider: EpisodesProvider,
    private val characterProvider: CharacterProvider,
    private val charactersProvider: CharactersProvider,
    private val charactersByEpisodeProvider: CharactersByEpisodeProvider
) {

    suspend fun getCharacter(id: Int): Character {
        val response = api.getCharacter(id)
        characterProvider.character = response
        return response;
    }

    suspend fun getCharacters(page: Int): Characters {
        val response = api.getCharacters(page)
        charactersProvider.characters = response
        return response;
    }

    suspend fun getCharactersByEpisode(characters: String): List<Character> {
        val response = api.getCharactersByEpisodes(characters)
        charactersByEpisodeProvider.charactersByEpisode = response
        return response
    }

    suspend fun getEpisodes(episodes: String): List<Episode> {
        val response = api.getEpisodes(episodes)
        episodesProvider.episodes = response
        return response
    }
}