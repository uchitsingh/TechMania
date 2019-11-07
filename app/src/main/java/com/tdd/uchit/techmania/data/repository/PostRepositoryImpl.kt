package com.tdd.uchit.techmania.data.repository

import com.tdd.uchit.techmania.data.model.Post
import com.tdd.uchit.techmania.data.remote.PostService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostRepositoryImpl(private val postService: PostService) : PostRepository {
    override fun fetchPosts(): Single<List<Post>> {
        return postService.fetchPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

