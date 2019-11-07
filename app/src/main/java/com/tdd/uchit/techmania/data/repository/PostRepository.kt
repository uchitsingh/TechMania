package com.tdd.uchit.techmania.data.repository

import com.tdd.uchit.techmania.data.model.Post
import io.reactivex.Single

interface PostRepository {
    fun fetchPosts(): Single<List<Post>>
}