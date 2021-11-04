package com.example.rickandmortyapp.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersProvider @Inject constructor(){
    var characters: Characters = Characters(emptyList())
}