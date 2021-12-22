package com.example.rickandmortyapp.data.model.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.HomeItem
import com.example.rickandmortyapp.data.model.holder.HomeViewHolder
import com.example.rickandmortyapp.ui.view.CharacterActivity
import com.example.rickandmortyapp.ui.view.EpisodeActivity

class HomeAdapter(private val homeItem: List<HomeItem>): RecyclerView.Adapter<HomeViewHolder>() {
    private var contextParent: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextParent = parent.context
        return HomeViewHolder(layoutInflater.inflate(R.layout.home_card, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        if (position == 0) {
            holder.itemView.setOnClickListener {
                val switchActivityIntent = Intent(contextParent, CharacterActivity::class.java)
                startActivity(contextParent!!, switchActivityIntent, null)
            }
        }
        if (position == 1) {
            holder.itemView.setOnClickListener {
                val switchActivityIntent = Intent(contextParent, EpisodeActivity::class.java)
                startActivity(contextParent!!, switchActivityIntent, null)
            }
        }
        return holder.bind(homeItem[position])
    }

    override fun getItemCount(): Int {
        return homeItem.size
    }
}