package com.example.rickandmortyapp.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersByEpisodeProvider @Inject constructor() {
    var charactersByEpisode: List<Character> = emptyList()
}