package com.example.tmdbclient.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.aritist.Artist
import com.example.tmdbclient.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private val artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(artists: Artist) {
        binding.titleTextView.text = artists.name
        binding.descriptionTextView.text = artists.popularity.toString()

        val posterURL: String = "https://image.tmdb.org/t/p/w500" + artists.profilePath

        Glide.with(binding.imageView.context).load(posterURL).into(binding.imageView)
    }

}