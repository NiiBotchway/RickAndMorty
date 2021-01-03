package com.ananseLabs.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ananseLabs.rickandmorty.R
import com.ananseLabs.rickandmorty.model.Episode
import com.squareup.picasso.Picasso

class EpisodeAdapter(val data: List<Episode>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_episode, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.name.text = item.name
        holder.seasonEpisode.text = holder.itemView.context.resources.getString(R.string.season_episode, item.season, item.number)
        Picasso.get().load(item.image.original).into(holder.imageView);
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.iv_episode_image)
    val name: TextView = itemView.findViewById(R.id.tv_episode_name)
    val seasonEpisode: TextView = itemView.findViewById(R.id.tv_season_episode)
}