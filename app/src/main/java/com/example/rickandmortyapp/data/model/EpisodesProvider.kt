package com.example.rickandmortyapp.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EpisodesProvider @Inject constructor() {
    var episodes: List<Episode> = emptyList()
}