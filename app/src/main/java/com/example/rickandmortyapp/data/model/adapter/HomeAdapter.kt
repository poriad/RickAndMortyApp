package com.example.rickandmortyapp.data.model.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.HomeItem
import com.example.rickandmortyapp.data.model.holder.HomeViewHolder

class HomeAdapter(private val homeItem: List<HomeItem>): RecyclerView.Adapter<HomeViewHolder>() {
    private var contextParent: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextParent = parent.context
        return HomeViewHolder(layoutInflater.inflate(R.layout.home_card, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        return holder.bind(homeItem[position])
    }

    override fun getItemCount(): Int {
        return homeItem.size
    }
}