package com.tdd.uchit.techmania.data.remote

import com.tdd.uchit.techmania.data.model.Post
import com.tdd.uchit.techmania.utils.Constant
import com.tdd.uchit.techmania.utils.RetrofitServiceProvider
import io.reactivex.Single
import retrofit2.http.GET

interface PostService {
    companion object {
        val instance: PostService by lazy {
            RetrofitServiceProvider.retrofit.create(PostService::class.java)
        }
    }

    @GET(Constant.POST_URL)
    fun fetchPosts(): Single<List<Post>>
}