package com.example.recyclerviewexample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_photograph.view.*
import java.util.*

class ImageRecyclerAdapter(val items: ArrayList<ImageObject>) :
    RecyclerView.Adapter<ImageRecyclerAdapter.ImageViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        return ImageViewHolder(inflater.inflate(R.layout.item_photograph, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(vh: ImageViewHolder, position: Int) {
        bind(vh, items[position])
        vh.itemView.setOnClickListener {
            items.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount)
        }
    }

    private fun bind(vh: ImageViewHolder, imageObject: ImageObject) {
        vh.authorTextView.text = "Author: ${imageObject.author}"
        vh.yearTextView.text = "Year: ${imageObject.year}"
        context?.let {
            Picasso.get()
                .load("https://picsum.photos/id/${imageObject.id}/200/300")
                .placeholder(it.getDrawable(R.drawable.ic_image))
                .error(it.getDrawable(R.drawable.ic_error))
                .into(vh.image)
        }
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authorTextView: TextView = itemView.author
        val yearTextView: TextView = itemView.year
        val image: ImageView = itemView.image
    }
}