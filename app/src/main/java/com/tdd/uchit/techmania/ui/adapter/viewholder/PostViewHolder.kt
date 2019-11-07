package com.tdd.uchit.techmania.ui.adapter.viewholder

import android.view.View

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tdd.uchit.techmania.data.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(post: Post) {
        post.apply {
            itemView.author.text = this.author
            itemView.date.text = this.date
            val pattern = "\\&#....;".toRegex()
            itemView.title.text = this.title.rendered.replace(pattern, "")
            Glide.with(itemView.context).load(this.image).into(itemView.post_image)
        }
    }
}
