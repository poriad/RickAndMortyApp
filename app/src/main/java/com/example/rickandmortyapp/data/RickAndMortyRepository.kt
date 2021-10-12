package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.CharacterProvider
import com.example.rickandmortyapp.data.model.Characters
import com.example.rickandmortyapp.data.model.CharactersProvider
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
}