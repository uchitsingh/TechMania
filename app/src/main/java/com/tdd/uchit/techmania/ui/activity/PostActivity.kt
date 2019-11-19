package com.tdd.uchit.techmania.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tdd.uchit.techmania.R
import com.tdd.uchit.techmania.data.model.Post
import com.tdd.uchit.techmania.data.remote.PostService
import com.tdd.uchit.techmania.data.repository.PostRepositoryImpl
import com.tdd.uchit.techmania.ui.adapter.PostAdapter
import com.tdd.uchit.techmania.ui.adapter.listener.PostClickListener
import com.tdd.uchit.techmania.ui.dialog.PostDescriptionDialog
import com.tdd.uchit.techmania.viewmodel.PostViewJModelFactory
import com.tdd.uchit.techmania.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*

class PostActivity : AppCompatActivity() {
    companion object {
        const val DIALOG_TITLE = "Description"
    }

    private lateinit var viewModel: PostViewModel
    private lateinit var adapter: PostAdapter

    private val postClickListener: PostClickListener = object : PostClickListener {
        override fun onClick(post: Post) {
            val postDescriptionDialog = PostDescriptionDialog.instance(post)
            postDescriptionDialog.show(supportFragmentManager, DIALOG_TITLE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

        viewModel = ViewModelProviders.of(
            this,
            PostViewJModelFactory(PostRepositoryImpl(PostService.instance))
        ).get(PostViewModel::class.java)

        viewModel.fetchPosts()
        viewModel.posts.observe(this, Observer {
            adapter.setData(it)
        })
    }

    private fun initRecyclerView() {
        post_recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = PostAdapter(postClickListener)
        post_recyclerview.adapter = adapter
    }
}
