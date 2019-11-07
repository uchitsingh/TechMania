package com.tdd.uchit.techmania.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tdd.uchit.techmania.data.repository.PostRepository

class PostViewJModelFactory(val repository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(repository) as T
    }
}