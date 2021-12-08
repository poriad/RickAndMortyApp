package com.example.rickandmortyapp.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterProvider @Inject constructor() {
    var character: Character = Character(0, "", "", "", "","", Location(""), Origin(""))
}