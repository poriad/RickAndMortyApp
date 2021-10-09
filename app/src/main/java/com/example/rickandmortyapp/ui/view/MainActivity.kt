package com.example.rickandmortyapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.Character
import com.example.rickandmortyapp.data.model.adapter.CharactersAdapter
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.ui.viewmodel.CharacterViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding;
    private lateinit var adapter: CharactersAdapter
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        characterViewModel.onCreate()
        characterViewModel.page = 7
        binding.rightPageId.setOnClickListener {
            Toast.makeText(this, characterViewModel.page , Toast.LENGTH_SHORT).show()
        }
        characterViewModel.charactersModel.observe(this, Observer {
            adapter = CharactersAdapter(it)
            binding.characterRecicler.layoutManager = LinearLayoutManager(this)
            binding.characterRecicler.adapter = adapter
        })

    }
}