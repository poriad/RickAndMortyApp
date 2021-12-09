package com.example.rickandmortyapp.data.model.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.data.model.HomeItem
import com.example.rickandmortyapp.databinding.HomeCardBinding
import com.squareup.picasso.Picasso

class HomeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var binding = HomeCardBinding.bind(view)

    fun bind(homeItem: HomeItem) {
        binding.title.text = homeItem.title
        binding.description.text = homeItem.description
        Picasso.get().load(homeItem.image).into(binding.image)
    }
}