package com.example.rickandmortyapp.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.model.HomeItem
import com.example.rickandmortyapp.data.model.InfiniteCarouselTransformer
import com.example.rickandmortyapp.data.model.adapter.HomeAdapter
import com.example.rickandmortyapp.data.model.holder.HomeViewHolder
import com.example.rickandmortyapp.databinding.ActivityHomeBinding
import com.yarolegovich.discretescrollview.DiscreteScrollView
import dagger.hilt.android.AndroidEntryPoint
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter




@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var mAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scrollView = findViewById<DiscreteScrollView>(R.id.homeScroll)
        mAdapter = HomeAdapter(getData())
        val wrapper: InfiniteScrollAdapter<*> =
            InfiniteScrollAdapter.wrap(mAdapter)
        scrollView.adapter = wrapper

        scrollView.setItemTransformer(InfiniteCarouselTransformer())

        // Refactor
        supportActionBar?.setHomeAsUpIndicator(R.mipmap.rick)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Refactor
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.page_2 -> {
                    startActivity(Intent(this, CharacterActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    false
                }
                R.id.page_3 -> {
                    startActivity(Intent(this, EpisodeActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    false
                }

                else -> {
                    false
                }
            }
        }
    }

    fun getData(): List<HomeItem> {
        var homeItemList: MutableList<HomeItem> = mutableListOf()
        homeItemList.add(HomeItem("Characters", "Search every character that appears in the series", "https://www.freepnglogos.com/uploads/rick-and-morty-png/rick-and-morty-portal-moon-mod-download-35.png"))
        homeItemList.add(HomeItem("Episodes", "Also you can check the episode, with every character which appears in it!", "https://cdn.custom-cursor.com/cursors/rick_and_morty_mr_meeseeks_box_1457.png"))
        homeItemList.add(HomeItem("Enjoy!", "This is my first app. Don't hate it too much!", "https://www.freepnglogos.com/uploads/rick-and-morty-png/rick-and-morty-png-lalingla-deviantart-21.png"))
        return homeItemList
    }
}