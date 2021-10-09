package com.example.rickandmortyapp.data.model

import com.example.rickandmortyapp.data.model.Character

class CharactersProvider {
    companion object {
        var characters: Characters = Characters(emptyList())
    }
}