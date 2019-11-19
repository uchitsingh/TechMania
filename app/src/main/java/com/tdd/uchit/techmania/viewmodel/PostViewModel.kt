package com.tdd.uchit.techmania.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tdd.uchit.techmania.data.model.Post
import com.tdd.uchit.techmania.data.repository.PostRepository
import com.tdd.uchit.techmania.utils.Constant
import io.reactivex.disposables.CompositeDisposable

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    private val disposable = CompositeDisposable()
    private var _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>>
        get() = _posts

    fun fetchPosts() {
        disposable.add(repository.fetchPosts()
            .subscribe({
                _posts.value = it
            }, {
                Log.i(Constant.TAG, it.message)
            }
            ))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}