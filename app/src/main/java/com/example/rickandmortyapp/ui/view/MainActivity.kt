package com.example.rickandmortyapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.adapter.CharactersAdapter
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.ui.viewmodel.CharacterViewModel
import com.example.rickandmortyapp.ui.viewmodel.CharacterViewModel.Companion.characterPage

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: CharactersAdapter
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_right_icon)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        characterViewModel.onCreate()
        binding.leftPageId.isEnabled = false

        binding.rightPageId.setOnClickListener {
            characterPage++
            characterViewModel.onClick()
            binding.pageNumber.text = "$characterPage Of 34"
            binding.leftPageId.isEnabled = characterPage != 1

            binding.rightPageId.isEnabled = characterPage != 34
        }

        binding.leftPageId.setOnClickListener {
            characterPage--
            characterViewModel.onClick()
            binding.pageNumber.text = "$characterPage Of 34"
            if (characterPage == 1) {
                binding.leftPageId.isEnabled = false
            }

            if (characterPage < 34 ) {
                binding.rightPageId.isEnabled = true
            }
        }

        characterViewModel.charactersModel.observe(this, {
            adapter = CharactersAdapter(it)
            binding.characterRecicler.layoutManager = LinearLayoutManager(this)
            binding.characterRecicler.adapter = adapter
        })

    }
}