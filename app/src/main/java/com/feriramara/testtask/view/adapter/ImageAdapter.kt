package com.feriramara.testtask.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.feriramara.testtask.R
import com.feriramara.testtask.data.SearchImage
import com.feriramara.testtask.data.UnsplashImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var list = mutableListOf<UnsplashImage>()

    fun updateList(images: List<UnsplashImage>) {
        list.clear()
        list.addAll(images)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = list[position]
        holder.textView.text = item.query_search
        Picasso.get().load(item.urls?.small).into(holder.imageView)
    }

    class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.search_image)
        val textView: TextView = itemView.findViewById(R.id.search_text)
    }

}