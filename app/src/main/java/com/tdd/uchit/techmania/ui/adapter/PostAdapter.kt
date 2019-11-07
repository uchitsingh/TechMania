package com.tdd.uchit.techmania.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tdd.uchit.techmania.ui.adapter.viewholder.PostViewHolder
import com.tdd.uchit.techmania.R
import com.tdd.uchit.techmania.data.model.Post
import com.tdd.uchit.techmania.ui.adapter.listener.PostClickListener

class PostAdapter constructor(private val postClickListener: PostClickListener): RecyclerView.Adapter<PostViewHolder>() {

    private val posts = mutableListOf<Post>() // you cannot reassign, but can alter the list value

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindItem(posts[position])
        holder.itemView.setOnClickListener{
            postClickListener.onClick(posts[holder.adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_post,
                parent,
                false
            )
        )

    fun setData(postList: List<Post>) {
        posts.clear()
        posts.addAll(postList)
        notifyDataSetChanged()
    }
}
